package br.miranda.zup.proposta.desafioDeProposta.validacao;

import br.miranda.zup.proposta.desafioDeProposta.proposta.Proposta;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DocumentoUnicoPorPropostaValidator implements ConstraintValidator<DocumentoUnicoPorProposta ,Object> {
    @PersistenceContext
    EntityManager em;

    @Override
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = em.createQuery
        ("SELECT 1 FROM "+ Proposta.class.getName() + " p WHERE p.documento = :valor");
        query.setParameter("valor" ,value);

        return query.getResultList().isEmpty();
    }
}
