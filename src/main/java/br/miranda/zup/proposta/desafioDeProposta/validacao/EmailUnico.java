package br.miranda.zup.proposta.desafioDeProposta.validacao;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EmailUnicoValidador.class})
public @interface EmailUnico {
    String message() default "Já existe uma proposta com esse documento!" ;
    Class<?> []groups() default {};
    Class<? extends Payload>[] payload() default {};
}
