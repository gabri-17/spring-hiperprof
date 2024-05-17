package br.com.treinaweb.hyperprof.api.alunos.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinaweb.hyperprof.api.alunos.dtos.AlunoRequest;
import br.com.treinaweb.hyperprof.api.alunos.dtos.AlunoResponse;
import br.com.treinaweb.hyperprof.api.alunos.services.AlunoService;
import br.com.treinaweb.hyperprof.api.common.routes.ApiRoutes;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AlunoRestController {
    private final AlunoService alunoService;

    /*
     * Em resumo, o padrão Delegate em Java é uma técnica poderosa para permitir que
     * objetos deleguem tarefas para outros objetos, promovendo a reutilização de
     * código e a separação de preocupações. É uma alternativa valiosa à herança
     * pode ser utilizado em uma variedade de contextos de desenvolvimento de
     * software.
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(ApiRoutes.CADASTRAR_ALUNOS)
    public AlunoResponse cadastrarAluno(
        @RequestBody @Valid AlunoRequest alunoRequest, 
        @PathVariable Long professorId
        ) {
        return alunoService.cadastrarAluno(alunoRequest, professorId);
    }

}
