
package ee.itcollage.garageapi.controller;

import ee.itcollage.garageapi.dto.Greeting;
import ee.itcollage.garageapi.server.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping
    public Greeting greeting(@RequestParam(name="name", required=false, defaultValue="World") String name) {
        return greetingService.buildGreeting(name);
    }

    @PostMapping
    public Greeting greeting(@RequestBody Greeting greeting){
        return greetingService.addPosted(greeting);
    }
}
