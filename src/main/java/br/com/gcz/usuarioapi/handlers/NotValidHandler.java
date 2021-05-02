package br.com.gcz.usuarioapi.handlers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class NotValidHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        String message = ex.getBindingResult().getFieldErrors().stream()
                .min((error1, error2) -> error1.getField().compareToIgnoreCase(error2.getField()))
                .map(ObjectError::getDefaultMessage).orElseGet(String::new);

        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, message, request.getDescription(false));
        return ResponseEntity.badRequest().headers(headers).body(apiError);
    }
}
