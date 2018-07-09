package catpet.learnmake.jib.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
@EnableConfigurationProperties(CommonProperties.class)
public class LocalizationConfig {

    @Autowired
    private CommonProperties commonProperties;

    @Bean(name = "messageSource")
    public ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames(commonProperties.getI18NLocation("classpath:/i18n/messages"));
        messageSource.setCacheSeconds(commonProperties.getI18nCacheSeconds());
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

}
