package br.com.treinaweb.hyperprof.api.common.routes;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiRoutes {
    // Bases das rotas
    public static final String API = "/api";
    public static final String AUTH = "/auth";
    public static final String ALUNOS = "/alunos";
    public static final String PROFESSORES = "/professores";
    public static final String LOGIN = API + AUTH + "/login";

    // Rotas relacionadas ao domínio de professor.
    public static final String BUSCAR_PROFESSORES = API + PROFESSORES;
    public static final String BUSCAR_PROFESSOR_POR_ID = API + PROFESSORES + "/{professorId}";
    public static final String CADASTRAR_PROFESSOR = API + PROFESSORES;

    // Rotas relacionadas ao domínio de aluno.
    public static final String CADASTRAR_ALUNOS = API + PROFESSORES + "/{professorId}" + ALUNOS;

}
