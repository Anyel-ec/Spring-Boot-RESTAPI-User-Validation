package top.anyel.app_prueba.shared_app.exceptions_app.api_app;

public interface ApiError_app {

    String message();

    static ApiError_app fieldApiError(String field, String message, Object rejectedValue) {
        return new ApiErrorField(field, message, rejectedValue);
    }


    record ApiErrorField(String field, String message, Object rejectedValue) implements ApiError_app {
    }
}
