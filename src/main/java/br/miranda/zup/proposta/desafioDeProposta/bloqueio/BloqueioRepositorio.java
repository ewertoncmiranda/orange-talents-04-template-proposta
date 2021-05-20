package br.miranda.zup.proposta.desafioDeProposta.bloqueio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloqueioRepositorio extends CrudRepository<Bloqueio,Long> {
}
