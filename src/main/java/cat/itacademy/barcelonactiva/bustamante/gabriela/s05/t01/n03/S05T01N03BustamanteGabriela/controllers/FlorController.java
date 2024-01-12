package cat.itacademy.barcelonactiva.bustamante.gabriela.s05.t01.n03.S05T01N03BustamanteGabriela.controllers;

import cat.itacademy.barcelonactiva.bustamante.gabriela.s05.t01.n03.S05T01N03BustamanteGabriela.exceptions.FlorNotFoundException;
import cat.itacademy.barcelonactiva.bustamante.gabriela.s05.t01.n03.S05T01N03BustamanteGabriela.model.domain.Flor;
import cat.itacademy.barcelonactiva.bustamante.gabriela.s05.t01.n03.S05T01N03BustamanteGabriela.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.bustamante.gabriela.s05.t01.n03.S05T01N03BustamanteGabriela.model.services.FlorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/flor")
public class FlorController {

    @Autowired
    private FlorServicio florServicio;

    @PostMapping("/add")
    public Mono<FlorDTO> createFlor(@RequestBody Flor flor) {
    return florServicio.crearFlor(flor)
           .map(florServicio::convertToDto);
    }

    @PutMapping("/update/{id}")
   /*public Mono<ResponseEntity<Flor>> update(@PathVariable int id, @RequestBody Flor flor) {
        return florServicio.updateFlor(id, flor.getNombreFlor(), flor.getPaisFlor())
                .map(updateFlorDTO -> new ResponseEntity<>(updateFlorDTO, HttpStatus.OK));*/

    public Mono<ResponseEntity<String>> updateFlor(@PathVariable int id, @RequestBody Flor flor) {
        return florServicio.updateFlor(id, flor.getNombreFlor(), flor.getPaisFlor())
                .map(updatedFlor -> {
                    // Lógica ya realizada en convertToDTO para determinar el tipoFlor
                    FlorDTO florDTO = florServicio.convertToDto(updatedFlor);
                    return ResponseEntity.ok("Flor actualizada exitosamente, Tipo: " + florDTO.getTipoFlor());
                })
                .onErrorReturn(FlorNotFoundException.class, ResponseEntity.status(HttpStatus.NOT_FOUND).body("Flor no encontrada con el ID: " + id))
                .onErrorReturn(RuntimeException.class, ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor"));

    }

    @GetMapping("/getAll")
    public Mono<ResponseEntity<List<FlorDTO>>> getAllFlor() {
        return florServicio.getAllFlor()
                .collectList()
                .map(allFlores -> ResponseEntity.ok(allFlores))
                .defaultIfEmpty(ResponseEntity.notFound().build());

    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Flor>> getFlorById(@PathVariable("id") Integer id) {

        return florServicio.getFlorById(id)
                .map(florDTO -> new ResponseEntity<>(florDTO, HttpStatus.OK))
                .onErrorReturn(WebClientResponseException.NotFound.class, new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/delete/{id}")
    public Mono<ResponseEntity<Void>> deleteFlorById(@PathVariable("id") Integer id) {
        return 	florServicio.deleteFlorById(id)
                .map(updateFlorDTO -> new ResponseEntity<Void>(HttpStatus.OK))
                .onErrorReturn(WebClientResponseException.NotFound.class, new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
    }
}
