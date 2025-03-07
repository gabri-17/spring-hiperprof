package br.com.treinaweb.hyperprof.api.professores.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinaweb.hyperprof.api.common.routes.ApiRoutes;
import br.com.treinaweb.hyperprof.api.professores.dtos.ProfessorRequest;
import br.com.treinaweb.hyperprof.api.professores.dtos.ProfessorResponse;
import br.com.treinaweb.hyperprof.api.professores.services.ProfessorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProfessorRestController {
    private final ProfessorService professorService;
    /*
     * O Spring além do uso da notação Autowired para injeção de dependência também
     * consegue fazê-la através do construtor.
     */

    @GetMapping(ApiRoutes.BUSCAR_PROFESSORES)
    public List<ProfessorResponse> buscarProfessores(
            @RequestParam(name = "q", required = false, defaultValue = "") String descricao) {
        return professorService.buscarProfessores(descricao);
    }

    @GetMapping(ApiRoutes.BUSCAR_PROFESSOR_POR_ID)
    public ProfessorResponse buscarProfessorPorId(@PathVariable Long professorId) {
        return professorService.buscarProfessorPorId(professorId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(ApiRoutes.CADASTRAR_PROFESSOR)
    // Método que está delegando para uma outra classe fazer.
    public ProfessorResponse cadastrarProfessor(
            @RequestBody @Valid ProfessorRequest professorRequest) {
        return professorService.cadastrarProfessor(professorRequest);
    }

}
