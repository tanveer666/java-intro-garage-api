package ee.itcollage.garageapi.controller;


import ee.itcollage.garageapi.model.Customer;
import ee.itcollage.garageapi.server.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> findAll() {
        return customerService.findAll();
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
