package ee.itcollage.garageapi.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

import static java.lang.String.format;


@RestController
@RequestMapping("/greeting") //Maps all the requests that come fro this subdirctory to this class
public class GreetingController {

    //maps all the GET requests from the aforementioned class to this method
    //Takes 2 parameters from the get request, puts the values "name=" into a string called name, puts the values after "age=" into an int called num
    @GetMapping
    public Greeting greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, @RequestParam(name = "age", required = false) Integer num) {
        String format = format("greeting %s", name); //basically sprintf.
        if (num == null) {
            return new Greeting(format, 0);
        }
        return new Greeting(format, num); //returns a Greeting object consisting of format and int num
    }


    @PostMapping
    public Greeting greeting(@RequestBody Greeting greeting) { //takes whatever thats inside the POST and puts it in a Greeting object.
        System.out.println(greeting);
        return new Greeting(greeting.getName() + " POSTEEEEED", greeting.getAge()); //simply returns a new Greeting object (with name + posteed) and age.
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



