package br.miranda.zup.proposta.desafioDeProposta.viagem;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViagemRepositorio extends CrudRepository<Viagem, Long>{
}
