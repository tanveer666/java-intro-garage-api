package ee.itcollage.garageapi.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/list")
public class ListController {
    @GetMapping
    public List<Greeting> list_of_greeting( ) //does not take any input parameter from the request
    {
        List<Greeting> greetingList = new ArrayList<>();
        greetingList.add(new Greeting("Hello", 10));
        greetingList.add(new Greeting("Hao", 20));
        greetingList.add(new Greeting("Knochiwa",30));
        greetingList.add(new Greeting("Bonjour",40));


        return greetingList;
    }

    @PostMapping
    public List<Greeting> lis_of_greeting() //does not take any input parameter from the request
    {
        List<Greeting> greetingList = new ArrayList<>();
        greetingList.add(new Greeting("Hello", 10));
        greetingList.add(new Greeting("Hao", 20));
        greetingList.add(new Greeting("Knochiwa",30));
        greetingList.add(new Greeting("Bonjour",40));


        return greetingList;
    }
}
