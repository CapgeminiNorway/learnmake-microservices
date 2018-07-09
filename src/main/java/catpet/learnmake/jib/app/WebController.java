package catpet.learnmake.jib.app;

import catpet.learnmake.jib.utils.AppConstants;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class WebController extends BaseController {

    @RequestMapping(method = RequestMethod.GET, produces=MediaType.TEXT_HTML_VALUE)
    public String getMainPage() {

        logThis(WebController.class.getSimpleName() + ".getMainPage", "getMainPage");
        return AppConstants.getIndex();
    }

    @GetMapping("/hello")
    public String getHello(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {

        logThis(WebController.class.getSimpleName() + ".getHello", "hello");
        model.addAttribute("name", name);
        return "hello";
    }
}
