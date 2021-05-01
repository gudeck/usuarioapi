package br.com.gcz.usuarioapi.validation.validator;

import br.com.gcz.usuarioapi.validation.constraint.UsuarioUniqueColumn;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UsuarioUniqueColumnValidator implements ConstraintValidator<UsuarioUniqueColumn, String> {

    private String column;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(UsuarioUniqueColumn constraintAnnotation) {
        column = constraintAnnotation.value();
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Query query = entityManager.createQuery("select 1 from Usuario where " + column + " =: value");
        List<?> list = query.setParameter("value", value).getResultList();
        return list.isEmpty();
    }
}
