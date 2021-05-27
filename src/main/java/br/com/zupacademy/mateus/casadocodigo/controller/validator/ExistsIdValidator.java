package br.com.zupacademy.mateus.casadocodigo.controller.validator;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.zupacademy.mateus.casadocodigo.controller.annotations.ExistsId;

public class ExistsIdValidator implements ConstraintValidator<ExistsId, Object>{

	private String domainAttribute;
	private Class<?> klass;
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void initialize(ExistsId params) {
		domainAttribute = params.fieldName();
		klass = params.domainClass();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		if(value == null) {
			return true;
		}
		
		Query query = manager.createQuery("select 1 from "+klass.getName()+" where "+domainAttribute+"=:value");
		query.setParameter("value", value);			
		List<?> list = query.getResultList();
		
		return !list.isEmpty();
	}
}