package ee.itcollage.garageapi.server;

import ee.itcollage.garageapi.model.Customer;
import ee.itcollage.garageapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerCrudService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }
}
