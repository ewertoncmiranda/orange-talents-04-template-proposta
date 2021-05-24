package br.miranda.zup.proposta.desafioDeProposta.novaviagem;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViagemRepositorio extends CrudRepository<Viagem , Long> {
}
