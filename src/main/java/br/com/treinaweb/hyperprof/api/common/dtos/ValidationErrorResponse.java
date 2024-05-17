package br.com.treinaweb.hyperprof.api.common.dtos;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
/*@Builder  Por padrão, não se consegue ter uma superclasse (mãe) e uma 
subclasse (filha) ambas com a notação do builder. */
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonNaming(SnakeCaseStrategy.class)
public class ValidationErrorResponse extends ErrorResponse {
    private Map<String, List<String>> errors;

}
