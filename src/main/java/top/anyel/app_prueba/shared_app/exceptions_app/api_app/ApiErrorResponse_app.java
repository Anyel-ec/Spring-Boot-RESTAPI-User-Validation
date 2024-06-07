package top.anyel.app_prueba.shared_app.exceptions_app.api_app;


import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.Instant;
import java.util.Collection;

import static java.util.Collections.emptyList;
import static java.util.Objects.isNull;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.ResponseEntity.status;

@ToString
@Getter
public final class ApiErrorResponse_app {

    private final Instant timestamp;
    private final int status;
    private final HttpStatus errorCode;
    private final String message;
    private final Collection<ApiError_app> errors;


    @Builder
    private ApiErrorResponse_app(HttpStatus httpStatus, String message, Collection<ApiError_app> errors) {
        this.timestamp = Instant.now();
        this.status = httpStatus.value();
        this.errorCode = httpStatus;
        this.message = message;
        this.errors = isNull(errors) ? emptyList() : errors;
    }

    public static ResponseEntity<ApiErrorResponse_app> badRequest(String message) {
        return ResponseEntity.badRequest()
                .contentType(APPLICATION_JSON)
                .body(ApiErrorResponse_app.builder()
                        .httpStatus(BAD_REQUEST)
                        .message(message)
                        .build());
    }

    public static ResponseEntity<ApiErrorResponse_app> notFound(String message) {
        return status(NOT_FOUND)
                .contentType(APPLICATION_JSON)
                .body(ApiErrorResponse_app.builder()
                        .httpStatus(NOT_FOUND)
                        .message(message)
                        .build());
    }

    public static ResponseEntity<ApiErrorResponse_app> unprocessableEntity(Collection<ApiError_app> errors, String message) {
        return ResponseEntity.unprocessableEntity()
                .contentType(APPLICATION_JSON)
                .body(ApiErrorResponse_app.builder()
                        .httpStatus(UNPROCESSABLE_ENTITY)
                        .message(message)
                        .errors(errors)
                        .build());
    }

    public static ResponseEntity<ApiErrorResponse_app> conflict(String message) {
        return status(CONFLICT)
                .contentType(APPLICATION_JSON)
                .body(ApiErrorResponse_app.builder()
                        .httpStatus(CONFLICT)
                        .message(message)
                        .build());
    }

    public static ResponseEntity<ApiErrorResponse_app> methodNotAllowed(HttpHeaders headers, String message) {
        return status(METHOD_NOT_ALLOWED)
                .headers(headers)
                .contentType(APPLICATION_JSON)
                .body(ApiErrorResponse_app.builder()
                        .httpStatus(METHOD_NOT_ALLOWED)
                        .message(message)
                        .build());
    }

    public static ResponseEntity<ApiErrorResponse_app> notAcceptable(String message) {
        return status(NOT_ACCEPTABLE)
                .contentType(APPLICATION_JSON)
                .body(ApiErrorResponse_app.builder()
                        .httpStatus(NOT_ACCEPTABLE)
                        .message(message)
                        .build());
    }

    public static ResponseEntity<ApiErrorResponse_app> unsupportedMediaType(HttpHeaders headers, String message) {
        return status(UNSUPPORTED_MEDIA_TYPE)
                .headers(headers)
                .contentType(APPLICATION_JSON)
                .body(ApiErrorResponse_app.builder()
                        .httpStatus(UNSUPPORTED_MEDIA_TYPE)
                        .message(message)
                        .build());
    }

    public static ResponseEntity<ApiErrorResponse_app> internalServerError(String message) {
        return ResponseEntity.internalServerError()
                .contentType(APPLICATION_JSON)
                .body(ApiErrorResponse_app.builder()
                        .httpStatus(INTERNAL_SERVER_ERROR)
                        .message(message)
                        .build());
    }

    public static ResponseEntity<ApiErrorResponse_app> internalServerError(String message, String details) {
        return ResponseEntity.internalServerError()
                .contentType(APPLICATION_JSON)
                .body(ApiErrorResponse_app.builder()
                        .httpStatus(INTERNAL_SERVER_ERROR)
                        .message(message)
                        .build());
    }

    public static ResponseEntity<ApiErrorResponse_app> internalServerError(String message, Collection<ApiError_app> errors) {
        return ResponseEntity.internalServerError()
                .contentType(APPLICATION_JSON)
                .body(ApiErrorResponse_app.builder()
                        .httpStatus(INTERNAL_SERVER_ERROR)
                        .message(message)
                        .errors(errors)
                        .build());
    }

    public static ResponseEntity<ApiErrorResponse_app> notFound(String message, String instance) {
        return ResponseEntity.status(NOT_FOUND)
                .contentType(APPLICATION_JSON)
                .body(ApiErrorResponse_app.builder()
                        .httpStatus(NOT_FOUND)
                        .message(message)
                        .build());

    }







}
