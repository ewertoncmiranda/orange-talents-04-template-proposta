package br.miranda.zup.proposta.desafioDeProposta.novaproposta;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropostaRepositorio extends CrudRepository<Proposta , Long> {
}
