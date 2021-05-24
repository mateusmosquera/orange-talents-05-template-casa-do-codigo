package br.com.zupacademy.mateus.casadocodigo.controller.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.zupacademy.mateus.casadocodigo.controller.validator.UniqueValueValidator;

@Documented
@Constraint(validatedBy = {UniqueValueValidator.class})
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueValue {
	
	String message() default "{com.br.zupacademy.mateus.casadocodigo.beanvalidation.uniquevalue}";
	
	Class<?>[] groups() default { };
	
	Class<? extends Payload>[] payload() default{ };
	
	String fieldName();
	
	Class<?> domainClass();
	
}
