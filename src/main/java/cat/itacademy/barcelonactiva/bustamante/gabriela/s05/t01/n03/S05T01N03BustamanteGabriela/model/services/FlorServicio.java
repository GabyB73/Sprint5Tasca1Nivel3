package cat.itacademy.barcelonactiva.bustamante.gabriela.s05.t01.n03.S05T01N03BustamanteGabriela.model.services;

import cat.itacademy.barcelonactiva.bustamante.gabriela.s05.t01.n03.S05T01N03BustamanteGabriela.model.domain.Flor;
import cat.itacademy.barcelonactiva.bustamante.gabriela.s05.t01.n03.S05T01N03BustamanteGabriela.model.dto.FlorDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

public interface FlorServicio {
    Mono<Flor> crearFlor(Flor flor);
    //Flor addFlor(Flor flor);
    Flux<FlorDTO> getAllFlor();
    Mono<String> updateFlor(Integer pk_FlorID, String nombreFlor, String paisFlor);
    Mono<Flor> getFlorById(int id);
    Mono<Void> deleteFlorById(int id);
    List<FlorDTO> convertToDtoList(List<Flor> flores);
    FlorDTO convertToDto(Flor nuevaFlor);

}
