package ee.itcollage.garageapi.controller;

import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;

@RestController
@RequestMapping("/number")
public class NumberController {

    @GetMapping
    public Number number(@RequestParam(name = "value", required = false, defaultValue = "zero") Integer num) { //takes the get request parameter, puts it into Integer called num
        return new Number(num); //creates a new Number object and returns it to spring
    }

    @PostMapping
    public Number number(@RequestBody Number num){ //Takes whatever thats in the request body, puts it into  Number object num
        return num; //simply returns num
    }
}
