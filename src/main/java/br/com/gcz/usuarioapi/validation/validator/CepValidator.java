package br.com.gcz.usuarioapi.validation.validator;

import br.com.gcz.usuarioapi.validation.constraint.CEP;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CepValidator implements ConstraintValidator<CEP, Long> {

    @Override
    public void initialize(CEP constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return String.valueOf(value).matches("\\d{8}");
    }
}
