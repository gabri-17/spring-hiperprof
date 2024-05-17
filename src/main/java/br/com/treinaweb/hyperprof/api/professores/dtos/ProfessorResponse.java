package br.com.treinaweb.hyperprof.api.professores.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
/*
 * O padrão Builder é um padrão de projeto criacional que permite a criação de
 * objetos complexos
 * passo a passo. Ele é especialmente útil quando você precisa criar objetos que
 * requerem muitos
 * parâmetros ou quando deseja que o processo de criação de objetos seja mais
 * flexível.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(SnakeCaseStrategy.class)
public class ProfessorResponse {
    // Representar o que será retornado na resposta HTTP.
    private long id;
    private String nome;
    private String email;
    private int idade;
    private String descricao;

    private BigDecimal valorHora;

    private String fotoPerfil;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
