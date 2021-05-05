package br.com.gcz.usuarioapi.annotation.constraint;

import br.com.gcz.usuarioapi.annotation.constraint.validator.UsuarioUniqueColumnValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = {UsuarioUniqueColumnValidator.class})
@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
@Documented
public @interface UsuarioUniqueColumn {

    Class<?>[] groups() default {};

    String message() default "";

    Class<? extends Payload>[] payload() default {};

    String value();

}
