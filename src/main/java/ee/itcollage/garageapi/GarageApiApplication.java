package ee.itcollage.garageapi;

import ee.itcollage.garageapi.model.Car;
import ee.itcollage.garageapi.model.Customer;
import ee.itcollage.garageapi.repository.CarRepository;
import ee.itcollage.garageapi.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GarageApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GarageApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new Customer("Jack", "Bauer"));
            repository.save(new Customer("Chloe", "O'Brian"));
            repository.save(new Customer("Kim", "Bauer"));
            repository.save(new Customer("David", "Palmer"));
            repository.save(new Customer("Michelle", "Dessler"));
        };
    }


    @Bean
    public CommandLineRunner demo2(CarRepository repo) {
    	return (args) -> {
    	    repo.save( new Car("Ford Mustang", "V8", 4.0));
    	    repo.save(new Car("Lamborghini Gallardo", "V10", 5.0));
    	    repo.save( new Car("Chevrolet Camaro", "V8", 4.0));
    	    repo.save(new Car("Nissan Skyline R34 GTR", "I6",2.6));
    	    repo.save(new Car("Toyota Supra", "I6", 3.0));
        };
    }
}

