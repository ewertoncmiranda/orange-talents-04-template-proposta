package br.miranda.zup.proposta.desafioDeProposta.validacao;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {DocumentoUnicoPorPropostaValidator.class})
public @interface DocumentoUnicoPorProposta {
    String message() default "Já existe uma proposta com esse documento!" ;
    Class<?> []groups() default {};
    Class<? extends Payload>[] payload() default {};
}
