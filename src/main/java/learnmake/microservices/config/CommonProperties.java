package learnmake.microservices.config;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.web.ResourceProperties.Content;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix="")
public class CommonProperties {

    private Content content = new Content();

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public String getI18NLocation(){
        return ""; // FIXME content.getI18nLocation();
    }

    public String[] getI18NLocation(String... args){
        List<String> locations = Lists.newArrayList();

        String remoteLocation = getI18NLocation(); //content.getI18nLocation();
        if(!StringUtils.isEmpty(remoteLocation)){
            locations.add(remoteLocation);

        }
        if(args != null){
            for(String location: args){
                locations.add(location);
            }
        }
        return locations.toArray(new String[locations.size()]);
    }

    public int getI18nCacheSeconds(){
        return 44; // FIXME content.getI18nCacheSeconds();
    }

    public String getMenuLocation(){
        return ""; // FIXME content.getI18nLocation();
    }
}
