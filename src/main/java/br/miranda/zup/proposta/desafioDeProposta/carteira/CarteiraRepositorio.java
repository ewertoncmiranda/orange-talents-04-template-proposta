package br.miranda.zup.proposta.desafioDeProposta.carteira;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface CarteiraRepositorio extends CrudRepository<Carteira,Long> {

}
