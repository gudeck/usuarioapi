package br.com.gcz.usuarioapi.error;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


public record ApiErrorResponse(LocalDateTime timestamp, Integer status, String error, String message, String path) {

    public ApiErrorResponse(HttpStatus status, String message, String path) {
        this(LocalDateTime.now(), status.value(), status.getReasonPhrase(), message, path.replace("uri=", ""));
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    public Integer getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
