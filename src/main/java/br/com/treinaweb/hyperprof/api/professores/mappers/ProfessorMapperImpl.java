package br.com.treinaweb.hyperprof.api.professores.mappers;

import org.springframework.stereotype.Component;

import br.com.treinaweb.hyperprof.api.professores.dtos.ProfessorRequest;
import br.com.treinaweb.hyperprof.api.professores.dtos.ProfessorResponse;
import br.com.treinaweb.hyperprof.core.models.Professor;

/*Na injeção de dependência você injeta o objeto (a dependência) na classe através de seu método 
construtor ou através de um método setter. */
@Component // injeção de dependência.

// Componente genérico dentro da aplicação.
public class ProfessorMapperImpl implements ProfessorMapper {

    @Override
    public ProfessorResponse toProfessorResponse(Professor professor) {
        if (professor == null) {
            return null;
        }

        return ProfessorResponse.builder()
                .id(professor.getId())
                .nome(professor.getNome())
                .email(professor.getEmail())
                .idade(professor.getIdade())
                .descricao(professor.getDescricao())
                .valorHora(professor.getValorHora())
                .fotoPerfil(professor.getFotoPerfil())
                .createdAt(professor.getCreatedAt())
                .updatedAt(professor.getUpdatedAt())
                .build();
    }

    @Override
    public Professor toProfessor(ProfessorRequest professorRequest) {
        /*Mapper que faz a conversão de uma instância de Professor Request para uma
         * da entidade Professor(classe).
          */
        if (professorRequest == null) {
            return null;
        }
        return Professor.builder()
                .nome(professorRequest.getNome())
                .email(professorRequest.getEmail())
                .idade(professorRequest.getIdade())
                .descricao(professorRequest.getDescricao())
                .valorHora(professorRequest.getValorHora())
                .password(professorRequest.getPassword())
                .build();
    }

}
