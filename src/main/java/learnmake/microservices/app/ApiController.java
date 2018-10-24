package learnmake.microservices.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/api")
public class ApiController {


    // TODO: API endpoints goes here

    @GetMapping("/pulse")
    public @ResponseBody
    ResponseEntity<String> pulseCheck() {

        log.info(".pulseCheck {}", "/pulse");
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}
