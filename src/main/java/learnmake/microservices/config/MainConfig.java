package learnmake.microservices.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;

@Configuration
@Import(value= {
        WebMvcConfig.class,
        ThymeleafConfig.class,
        LocalizationConfig.class
})
public class MainConfig {

    /**
     * Application custom initialization code.
     */
    @PostConstruct
    public void initApp() {
    }
}
