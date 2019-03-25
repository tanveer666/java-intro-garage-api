
package ee.itcollage.garageapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

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
    // create GET method that returns numbers
    @GetMapping("numbers")
    public List<Integer> numbers() {
        return Arrays.asList(1, 2, 3);
    }

    //todo
    // create GET method that returns a list of greetings
    @GetMapping("list")
    public List<Greeting> greetings() {
        return Arrays.asList(new Greeting("We are legion!", 1), new Greeting("We are bob!", 2));
    }

    //todo
    // * create an example of @PathVariable
    // * test out PUT, DELETE or PATCH method
    // garage-cars/garage-cars-solution branches
}
