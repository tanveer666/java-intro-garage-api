
package ee.itcollage.garageapi.cars;

import com.google.common.collect.Lists;
import ee.itcollage.garageapi.controller.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;


@RestController
@RequestMapping("/cars")
public class CarController {

    private List<Car> cars = Lists.newArrayList(new Car(1L, "Jaguar"));

    @GetMapping
    public List<Car> getCars() {
        return cars;
    }

    //todo
    // get 1 car
    // save new car
    // update a car
    // delete a car
}
