package br.com.gcz.usuarioapi.error;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


public final class ApiError {

    private final LocalDateTime timestamp = LocalDateTime.now();
    private final Integer status;
    private final String error;
    private final String message;
    private final String path;

    public ApiError(HttpStatus status, String message, String path) {
        this.status = status.value();
        this.error = status.getReasonPhrase();
        this.message = message;
        this.path = path.replace("uri=", "");
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
