package br.miranda.zup.proposta.desafioDeProposta.cartao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartaoRepositorio  extends CrudRepository<Cartao , Long> {

}
