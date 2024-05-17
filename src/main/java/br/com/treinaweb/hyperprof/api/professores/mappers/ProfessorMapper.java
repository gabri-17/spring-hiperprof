package br.com.treinaweb.hyperprof.api.professores.mappers;

import br.com.treinaweb.hyperprof.api.professores.dtos.ProfessorRequest;
import br.com.treinaweb.hyperprof.api.professores.dtos.ProfessorResponse;
import br.com.treinaweb.hyperprof.core.models.Professor;

/*
 * Princípio SOLID -> uso da letra D: princípio da inversão de dependência -
 * basicamente, diz que sempre deve-se depender de abstrações (significa 
 * depender de Interfaces. Quando uma classe depende de uma interface ela 
 * pode receber qualquer dependência que satisfaça aquele “contrato” 
 * (interface)) e não de implementações.
 */
public interface ProfessorMapper {
    Professor toProfessor(ProfessorRequest professorRequest);
    ProfessorResponse toProfessorResponse(Professor professor);
}
