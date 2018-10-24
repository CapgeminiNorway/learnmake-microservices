package learnmake.microservices.app;

import learnmake.microservices.utils.AppConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequestMapping("/")
public class WebController {

    @RequestMapping(method = RequestMethod.GET, produces=MediaType.TEXT_HTML_VALUE)
    public String getMainPage() {

        log.info(".getMainPage");
        return AppConstants.getIndex();
    }

    @GetMapping("/hello")
    public String getHello(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {

        log.info(".getHello");
        model.addAttribute("name", name);
        return "hello";
    }
}
