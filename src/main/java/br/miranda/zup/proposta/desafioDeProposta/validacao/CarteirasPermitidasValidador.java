package br.miranda.zup.proposta.desafioDeProposta.validacao;

import br.miranda.zup.proposta.desafioDeProposta.carteira.TipoCarteira;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CarteirasPermitidasValidador implements HibernateConstraintValidator<CarteirasPermitidas ,TipoCarteira> {

    @Override
    public boolean isValid(TipoCarteira value, ConstraintValidatorContext context) {
        TipoCarteira carteira = value;
        return carteira.equals(TipoCarteira.PAYPAL) || carteira.equals(TipoCarteira.SAMSUNG);
    }
}
