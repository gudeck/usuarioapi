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

    private ApiError createBadRequestError(WebRequest request, String message) {
        String path = request.getDescription(false).replace("uri=", "");
        return new ApiError(HttpStatus.BAD_REQUEST, message, path);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        String message = ex.getBindingResult().getAllErrors().stream().findFirst().map(ObjectError::getDefaultMessage).orElseGet(String::new);

        ApiError apiError = createBadRequestError(request, message);
        return ResponseEntity.badRequest().headers(headers).body(apiError);
    }
}
