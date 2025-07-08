package cat.itacademy.barcelonactiva.bustamante.gabriela.s05.t01.n03.S05T01N03BustamanteGabriela.model.services;

import cat.itacademy.barcelonactiva.bustamante.gabriela.s05.t01.n03.S05T01N03BustamanteGabriela.exceptions.FlorNotFoundException;
import cat.itacademy.barcelonactiva.bustamante.gabriela.s05.t01.n03.S05T01N03BustamanteGabriela.model.domain.Flor;
import cat.itacademy.barcelonactiva.bustamante.gabriela.s05.t01.n03.S05T01N03BustamanteGabriela.model.dto.FlorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FlorServicioImpl implements FlorServicio{

    @Autowired
    private WebClient webClient;

    @Override
    public Mono<Flor> crearFlor(Flor flor) {
        Mono<Flor> mono = webClient.post().uri("/add")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(flor), FlorDTO.class)
                .retrieve()
                .bodyToMono(Flor.class);
        return mono;
    }

    @Override
    public Mono<Flor> getFlorById(int id) {
        return webClient
                .get()
                .uri("/getOne/{id}", id)
                .retrieve()
                .bodyToMono(Flor.class);

    }

    @Override
    public Mono<String> updateFlor(Integer pk_FlorID, String nombreFlor, String paisFlor) {
        Flor flor = new Flor();
        flor.setNombreFlor(nombreFlor);
        flor.setPaisFlor(paisFlor);

        return webClient
                .put()
                .uri("/update/{id}", pk_FlorID)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .bodyValue(flor) // <- aquí mando el objeto completo
                .retrieve()
                .bodyToMono(String.class);
    }

        @Override
    public Mono<Void> deleteFlorById(int id) {
        return webClient.delete().uri("/delete/{id}", id)
                .retrieve()
                .bodyToMono(Void.class);
    }

    @Override
    public Flux<FlorDTO> getAllFlor() {
        return webClient.get().uri("/getAll")
                .retrieve()
                .bodyToFlux(FlorDTO.class);
    }
    //Métodos de conversión
    //Método para convertir el DTO en la Entidad
    @Override
    public List<FlorDTO> convertToDtoList(List<Flor> flores) {
        return flores.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    //Método para convertir la Entidad en DTO
    @Override
    public FlorDTO convertToDto(Flor nuevaFlor) {
        FlorDTO florDTO = new FlorDTO();
        florDTO.setPk_FlorID(nuevaFlor.getPk_FlorID());
        florDTO.setNombreFlor(nuevaFlor.getNombreFlor());
        florDTO.setPaisFlor(nuevaFlor.getPaisFlor());

        // Lógica para determinar el tipo de sucursal basado en la lista de países de la UE
        if (FlorDTO.getPaisesUE().contains(nuevaFlor.getPaisFlor())) {
            florDTO.setTipoFlor("UE");
        } else {
            florDTO.setTipoFlor("Fuera UE");
        }

        return florDTO;
    }

}
