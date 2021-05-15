package br.miranda.zup.proposta.desafioDeProposta.proposta;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropostaRepositorio extends CrudRepository<Proposta, Long> {
    @Query("SELECT p FROM Proposta p WHERE statusProposta = 'ELEGIVEL' AND p.cartao = null")
    List<Optional<Proposta>> buscarPropostas();
}
