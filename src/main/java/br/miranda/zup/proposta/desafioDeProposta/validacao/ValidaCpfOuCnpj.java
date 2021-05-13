package br.miranda.zup.proposta.desafioDeProposta.validacao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;

import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

@Target({ElementType.METHOD,ElementType.FIELD,ElementType.ANNOTATION_TYPE ,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@CPF
@CNPJ
@ReportAsSingleViolation
@ConstraintComposition(CompositionType.OR)
public @interface ValidaCpfOuCnpj {
	String message()default "Documento com formato invalido";
	Class<?>[] groups() default {};
	Class<? extends Payload> [] payload() default{};
}
