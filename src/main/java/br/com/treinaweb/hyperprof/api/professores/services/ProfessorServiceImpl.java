package br.com.treinaweb.hyperprof.api.professores.services;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.treinaweb.hyperprof.api.professores.dtos.ProfessorRequest;
import br.com.treinaweb.hyperprof.api.professores.dtos.ProfessorResponse;
import br.com.treinaweb.hyperprof.api.professores.mappers.ProfessorMapper;
import br.com.treinaweb.hyperprof.core.exceptions.ProfessorNotFoundException;
import br.com.treinaweb.hyperprof.core.repositories.ProfessorRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {
    // Boa prática: as dependências serem definidas como final.
    private final ProfessorMapper professorMapper;
    private final PasswordEncoder passwordEncoder;
    private final ProfessorRepository professorRepository;

    @Override
    public List<ProfessorResponse> buscarProfessores(String descricao) {
        return professorRepository.findByDescricaoContaining(descricao)
                // stream API.
                .stream()

                // converter em uma lista de ProfessorResponse.
                // uso Method Reference.
                .map(professorMapper::toProfessorResponse)
                .toList();
    }

    @Override
    public ProfessorResponse buscarProfessorPorId(Long professorId) {
        return professorRepository.findById(professorId)
                .map(professorMapper::toProfessorResponse)
                .orElseThrow(ProfessorNotFoundException::new);
    }

    // Validação cadastroProfessor dentro da camada service não é adequado.
    @Override
    public ProfessorResponse cadastrarProfessor(ProfessorRequest professorRequest) {
        var professorParaCadastrar = professorMapper.toProfessor(professorRequest);
        /*
         * Pegando a senha atual do professor, fazendo o hash dela e então utilizando
         * ele para atualizar a senha do professor.
         */
        professorParaCadastrar.setPassword(passwordEncoder.encode(professorParaCadastrar.getPassword()));
        var professorCadastrado = professorRepository.save(professorParaCadastrar);
        return professorMapper.toProfessorResponse(professorCadastrado);
    }

}
