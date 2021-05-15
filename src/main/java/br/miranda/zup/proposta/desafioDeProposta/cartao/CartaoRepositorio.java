package br.miranda.zup.proposta.desafioDeProposta.cartao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepositorio  extends CrudRepository<Cartao , Long> {
}
