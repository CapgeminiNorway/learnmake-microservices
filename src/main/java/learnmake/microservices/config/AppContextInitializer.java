package learnmake.microservices.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AppContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    private static final Logger logger = LoggerFactory.getLogger(AppContextInitializer.class);

    @Override
    public void initialize(ConfigurableApplicationContext ac) {
        logger.info("Application started with active profiles: " + Arrays.asList(ac.getEnvironment().getActiveProfiles()));

        Map<String, Object> mapElements = new HashMap<>();
        for (Iterator<PropertySource<?>> it = (ac.getEnvironment()).getPropertySources().iterator(); it.hasNext();) {
            @SuppressWarnings("rawtypes")
            PropertySource propertySource = it.next();
            if (propertySource instanceof MapPropertySource) {
                mapElements.putAll(((MapPropertySource) propertySource).getSource());
            }
        }

        for (Map.Entry<String, Object> entry : mapElements.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            logger.debug(key + " : " + value);
        }
    }

}
