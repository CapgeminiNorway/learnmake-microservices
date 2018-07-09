package catpet.learnmake.jib.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class ApiController extends BaseController {


    // TODO: API endpoints goes here

    @GetMapping("/pulse")
    public @ResponseBody
    String pulseCheck() {

        logThis(ApiController.class.getSimpleName() + ".pulseCheck", "pulse");
        return "OK";//new ResponseEntity<>("OK", HttpStatus.OK);
    }
}
