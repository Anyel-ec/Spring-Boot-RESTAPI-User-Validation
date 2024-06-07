package top.anyel.app_prueba.shared_app.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomLogger_app implements ICustomLogger_app {
    private final Logger logger;

    public CustomLogger_app(Class<?> clazz) {
        this.logger = LoggerFactory.getLogger(clazz);
    }

    @Override
    public void logInfo(String message) {
        logger.info(message);
    }

    @Override
    public void logInfo(String message, Exception e) {
        logger.info(message, e);
    }

    @Override
    public void logDebug(String message) {
        logger.debug(message);
    }

    @Override
    public void logDebug(String message, Exception e) {
        logger.debug(message, e);
    }

    @Override
    public void logWarn(String message) {
        logger.warn(message);
    }

    @Override
    public void logWarn(String message, Exception e) {
        logger.warn(message, e);
    }

    @Override
    public void logError(String message, Exception e) {
        logger.error(message);
    }

    @Override
    public void logError(String message) {
        logger.error(message);
    }
}