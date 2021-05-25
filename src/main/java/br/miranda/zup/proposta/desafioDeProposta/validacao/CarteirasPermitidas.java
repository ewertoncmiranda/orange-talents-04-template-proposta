package br.miranda.zup.proposta.desafioDeProposta.validacao;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CarteirasPermitidasValidador.class)
public @interface CarteirasPermitidas {
    String message() default "Carteiras SAMSUNG/PAYPAL permitidas!" ;
    Class<?> []groups() default {};
    Class<? extends Payload>[] payload() default {};
}
