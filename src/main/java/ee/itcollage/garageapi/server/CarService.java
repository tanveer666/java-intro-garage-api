package ee.itcollage.garageapi.server;

import ee.itcollage.garageapi.model.Car;
import ee.itcollage.garageapi.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> findAll() {
        return carRepository.findAll();
    }

}
