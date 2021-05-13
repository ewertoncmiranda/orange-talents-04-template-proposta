package br.miranda.zup.proposta.desafioDeProposta.proposta;

import br.miranda.zup.proposta.desafioDeProposta.proposta.Proposta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropostaRepositorio extends CrudRepository<Proposta, Long> {
}
