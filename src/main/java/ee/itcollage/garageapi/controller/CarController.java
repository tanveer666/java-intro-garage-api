package ee.itcollage.garageapi.controller;


import ee.itcollage.garageapi.model.Car;
import ee.itcollage.garageapi.repository.CarRepository;
import ee.itcollage.garageapi.server.CarService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CarService carService;

    @PostMapping
    public void addCar(@RequestBody Car car) {
        carRepository.save(car);
    }

    @PutMapping("/{id}")
    public void updateCar(@PathVariable Long id, @NotNull @RequestBody Car car) {
        Car updatedCar = carRepository.findById(id).get();
        updatedCar.setModel(car.getModel());
        updatedCar.setDisplacement(car.getDisplacement());
        updatedCar.setEngineType(car.getEngineType());

        carRepository.save(updatedCar);
    }

    @DeleteMapping("/{id}")
    public void removeCar(@PathVariable long id) {
        carRepository.deleteById(id);
    }

    @GetMapping
    public List<Car> getCars() {
        return carRepository.findAll();
    }

    @GetMapping("/{id}")
    public Car getCar(@PathVariable Long id) {
        Optional<Car> car = carRepository.findById(id);
        return car.
                orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "id does not exist!"));
    }

    @GetMapping("/engine/{type}")
    public List<Car> getCarByEngine(@PathVariable String type) {
        return carRepository.findByEngineType(type);
    }

}
