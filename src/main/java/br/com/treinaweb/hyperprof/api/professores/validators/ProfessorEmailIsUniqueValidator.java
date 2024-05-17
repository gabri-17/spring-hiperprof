package br.com.treinaweb.hyperprof.api.professores.validators;

import org.springframework.stereotype.Component;

import br.com.treinaweb.hyperprof.core.repositories.ProfessorRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
// Implementação da validação de email único.
public class ProfessorEmailIsUniqueValidator implements ConstraintValidator<ProfessorEmailIsUnique, String> {
    private final ProfessorRepository professorRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // Aonde fica toda a lógica de validação.
        if (value == null) {
            // Não é obrigação de ProfessorEmailIsUnique verificar se é nulo ou não.
            return true;
        }

        /*
         * Se o professorRepository.existsByEmail retornar true, quer dizer que a 
         * validação falhou. Então, deve-se inverter.
         */
        return !professorRepository.existsByEmail(value);

        // return false; //validação falhou com esse retorno.
    }

}
