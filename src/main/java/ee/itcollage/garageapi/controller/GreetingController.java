
package ee.itcollage.garageapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.String.format;


@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping
    public Greeting greeting(@RequestParam(name="name", required=false, defaultValue="World") String name) {
        String format = format("greeting %s", name);
        return new Greeting(format);
    }

    @PostMapping
    public Greeting greeting(@RequestBody Greeting greeting){
        System.out.println(greeting);
        return new Greeting(greeting.getName() +  " POSTEEEEED");
    }

    //todo
    // * do you understand what's going on?
    // * install postman and try to access POST method
    // * create GET method that returns numbers
    // * create GET method that returns a list of greetings
    // * add more info to Greeting object
    // * create an example of @PathVariable
    // * test out PUT, DELETE or PATCH method
}
