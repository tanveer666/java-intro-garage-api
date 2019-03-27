package ee.itcollage.garageapi.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/other")
public class OtherController {

    @GetMapping
    public String other(@RequestParam(name = "value", required = false) String param) {
    return "Got something so must return somthing, so have a string!";

    }

    @PutMapping
    public Greeting other(@RequestBody Greeting other_greet_obj) {
        other_greet_obj.setName( other_greet_obj.getName()+ " PUUUUT");
        return  other_greet_obj;
    }

    @DeleteMapping
    public String otherDel(@RequestBody String greet) {
        return "nothing to delete as there is no database :( so have a " + greet;
    }


}
