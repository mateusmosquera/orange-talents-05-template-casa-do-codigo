package br.com.zupacademy.mateus.casadocodigo.controller.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.zupacademy.mateus.casadocodigo.controller.validator.ExistsIdValidator;

@Documented
@Constraint(validatedBy = {ExistsIdValidator.class})
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsId {

	String message() default "{com.deveficiente.beanvalidation.existsid}";
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };
	String fieldName();
	Class<?> domainClass();
}