package ee.itcollage.garageapi.controller;


import ee.itcollage.garageapi.model.Car;
import ee.itcollage.garageapi.repository.CarRepository;
import ee.itcollage.garageapi.server.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void updateCar(@PathVariable Long id, @RequestBody Car car) {
        Car updatedCar = carRepository.findById(id).get();
        updatedCar.setModel(car.getModel());
        updatedCar.setDisplacement(car.getDisplacement());
        updatedCar.setEngineType(car.getEngineType());

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
        return carRepository.findById(id).get();
    }

    @GetMapping("/engine/{type}")
    public List<Car> getCarByEngine(@PathVariable String type) {
        return carRepository.findByEngineType(type);
    }

}
