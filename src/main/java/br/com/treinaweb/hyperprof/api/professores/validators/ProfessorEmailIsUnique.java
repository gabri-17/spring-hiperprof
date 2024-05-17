package br.com.treinaweb.hyperprof.api.professores.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.RetentionPolicy;

@Target(ElementType.FIELD) //informar aonde essa anotação pode ser utilizada.
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ProfessorEmailIsUniqueValidator.class)
public @interface ProfessorEmailIsUnique {

    String message() default "já está sendo utilizado";
    Class<?>[] groups() default {}; // class genérico com array vazio.
    Class<? extends Payload>[] payload() default {};
}
