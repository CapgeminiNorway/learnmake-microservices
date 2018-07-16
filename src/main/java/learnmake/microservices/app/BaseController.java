package learnmake.microservices.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    protected void logThis(String controllerName, Object logThis) {
        logThis(controllerName, logThis, "");
    }
    protected void logThis(String controllerName, Object logThis, String level) {
        if ("error".equalsIgnoreCase(level)) {
            LOGGER.error("{} -> {}", controllerName, logThis);
        }
        else if ("debug".equalsIgnoreCase(level)) {
            LOGGER.debug("{} -> {}", controllerName, logThis);
        }
        else {// default: info
            LOGGER.info("{} -> {}", controllerName, logThis);
        }
    }
}
