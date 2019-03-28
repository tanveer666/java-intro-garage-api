
package ee.itcollage.garageapi.cars;

import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.String.format;


@RestController

@RequestMapping("/cars") //class level controller, maps all requests made on the URL cars to this class (and methods)
public class CarController {

    private List<Car> cars = Lists.newArrayList(new Car(1L, "Jaguar"), new Car(2L, "Mercedes"));

    @GetMapping //maps to all get requests on /cars only
    public List<Car> getCars() {
        return cars;
    }


    @GetMapping("/{id}") //maps all get requests on /cars/int to this
    public Car carGet(@PathVariable int id) {

        List<Car> get = validateId(id);

        if (get.isEmpty()) {
            return new Car(0L, format("no such car exists by the id of %d", id));
        } else {
            return get.get(0);
        }

    }

    @PostMapping()
    public void carPost(@RequestBody Car newCar) {
        cars.add(newCar);
    }

    @PutMapping("/{id}")
    public void carPut(@PathVariable int id,@RequestBody Car aCar) {
        cars = removeCarFromList(id);
        aCar.setId( new Long(id) );
        cars.add(aCar);
    }

    @DeleteMapping("/{id}")
    public void carDel(@PathVariable int id) {
        cars = removeCarFromList(id);

    }


    private List<Car> validateId(int id) {
        return cars.stream()
                .filter(car -> car.getId().intValue() == id)
                .collect(Collectors.toList());
    }

    private List<Car> removeCarFromList(int id) {
        return cars.stream()
                .filter(car -> car.getId().intValue() != id)
                .collect(Collectors.toList());

    }


    //todo
    // get 1 car
    // save new car
    // update a car
    // delete a car
}
