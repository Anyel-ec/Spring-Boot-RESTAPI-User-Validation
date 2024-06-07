package top.anyel.app_prueba.shared_app.logger;


import org.springframework.stereotype.Component;

@Component
public class CustomLoggerFactory_app {
    public CustomLogger_app getLogger(Class<?> clazz) {
        return new CustomLogger_app(clazz);
    }
}
