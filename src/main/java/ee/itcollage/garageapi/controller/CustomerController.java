package ee.itcollage.garageapi.controller;


import ee.itcollage.garageapi.model.Customer;
import ee.itcollage.garageapi.repository.CustomerRepository;
import ee.itcollage.garageapi.server.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerrepository;

    @GetMapping
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @GetMapping("{id}")
    public Customer findById(@PathVariable Long id) {
        //return findById(id);
        Customer ret_val = customerrepository.getOne(id);
        return ret_val;
    }

    @GetMapping("lastName/{lastname}")
    public List<Customer> findByLastName(@PathVariable String lastname) {
        return customerrepository.findByLastName(lastname);
    }

    @PostMapping
    public void addCustomer(@RequestBody Customer aCustomer) {
        customerrepository.save(aCustomer);
    }

    @DeleteMapping("{id}")
    public void removeCustomer(@PathVariable Long id) {
        customerrepository.deleteById(id);
    }

    @PutMapping("{id}")
    public void updateCustomer(@PathVariable Long id, @RequestBody Customer aCustomer) {
        Customer existingCustomer = customerrepository.getOne(id);
        existingCustomer.setFirstName(aCustomer.getFirstName());
        existingCustomer.setLastName(aCustomer.getLastName());
        customerrepository.save(existingCustomer);
    }

    //todo
    // * do you understand what's going on?
    // * connect to database
    // url: jdbc:h2:~/test;AUTO_SERVER=TRUE
    // username: test password:test
    // * create methods GET methods for findById and findByLastName
    // * what to do if database doesn't have Customer by that id or last name
    // * create another database entity
    // * fill that entity with data
    // * create controller, getmapping and service for that entity

}
