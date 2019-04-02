package ee.itcollage.garageapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ee.itcollage.garageapi.model.Car;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByEngineType(String engineType);

}
