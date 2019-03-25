
package ee.itcollage.garageapi.cars;

import com.google.common.collect.Lists;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/cars")
public class CarController {

    private List<Car> cars = Lists.newArrayList(
            new Car(1L, "Jaguar"),
            new Car(2L, "Mercedes")
    );

    @GetMapping
    @CrossOrigin
    public List<Car> getCars() {
        return cars;
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public Car getCar(@PathVariable Long id) {
        return findCarById(id);
    }

    @PostMapping
    @CrossOrigin
    public Car saveCar(@RequestBody Car car) {
        validateIdAndName(car);
        cars.add(car);
        return car;
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public Car updateCar(@PathVariable Long id, @RequestBody Car car) {
        validateIdAndName(car);
        Car carInTheList = findCarById(id);
        carInTheList.setName(car.getName());
        return carInTheList;
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    public void deleteCar(@PathVariable Long id) {
        Car carInTheList = findCarById(id);
        cars.remove(carInTheList);
    }

    private Car findCarById(@PathVariable Long id) {
        return cars.stream()
                .filter(c -> c.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "id doesnt exist"));
    }

    private void validateIdAndName(@RequestBody Car car) {
        if (car.getId() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id doesnt exist");
        }
        if (car.getName() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "model doesnt exist");
        }
    }
}
