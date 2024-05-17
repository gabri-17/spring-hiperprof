package br.com.treinaweb.hyperprof.api.common.handlers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;

import br.com.treinaweb.hyperprof.api.common.dtos.ErrorResponse;
import br.com.treinaweb.hyperprof.api.common.dtos.ValidationErrorResponse;
import br.com.treinaweb.hyperprof.core.exceptions.ModelNotFoundException;

// Quando se quer que uma classe tenha seus métodos executados para todos os controllers.
@RestControllerAdvice
public class RestControllerExceptionHandler extends ResponseEntityExceptionHandler {
    private final SnakeCaseStrategy snakeCaseStrategy = new SnakeCaseStrategy();

    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleModelNotFoundException(
            ModelNotFoundException exception, WebRequest request) {
        var status = HttpStatus.NOT_FOUND;
        var body = ErrorResponse.builder()
                .status(status.value())
                .error(status.getReasonPhrase())
                .message(exception.getLocalizedMessage())
                .cause(exception.getClass().getSimpleName())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<ErrorResponse>(body, status);
    }

    @SuppressWarnings("null")
    @Override
    @Nullable
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode statusCode,
            WebRequest request) {
        var status = (HttpStatus) statusCode; // casting para HttpStatus.
        var errors = new HashMap<String, List<String>>();
        // Processo de mapear a lista de fieldErrors.
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            var fieldName = snakeCaseStrategy.translate(error.getField()); /*Conversão 
            de Snake Case para Camel Case.*/
            var errorMessage = error.getDefaultMessage();
            // Verificação se já existe uma chave com esse nome do campo.
            if (errors.containsKey(fieldName)) {
                /*
                 * Pega o arrayList que está associado a esse campo e adiciona-se mais
                 * uma mensagem de erro .
                 */
                errors.get(fieldName).add(errorMessage);
            } else {
                // Criação da chave não existente.
                errors.put(fieldName, new ArrayList<String>(Arrays.asList(errorMessage)));
            }
        });
        var body = ValidationErrorResponse.builder()
                .status(status.value())
                .error(status.getReasonPhrase())
                .message("Validation Error!")
                .cause(ex.getClass().getSimpleName())
                .timestamp(LocalDateTime.now())
                .errors(errors)
                .build();
        return new ResponseEntity<Object>(body, headers, status);

    }
}
