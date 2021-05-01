package br.com.gcz.usuarioapi.validation.constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * O elemento anotado deve seguir o padrão de um CEP apenas com caracteres
 * numéricos: (\d+){8}
 *
 * @author Gustavo Zucolotto
 */
@Pattern(regexp = "(\\d+){8}")
@Constraint(validatedBy = {})
@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
@Documented
public @interface CEP {

    Class<?>[] groups() default {};

    String message() default "";

    Class<? extends Payload>[] payload() default {};

}

