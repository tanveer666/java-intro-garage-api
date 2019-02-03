package ee.itcollage.garageapi.controller;


import ee.itcollage.garageapi.model.Customer;
import ee.itcollage.garageapi.server.CustomerCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerSaveController {

    @Autowired
    private CustomerCrudService customerCrudService;

    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerCrudService.save(customer);
    }

    //todo
    // * test in postman or intelliJ rest service saving a new customer
    // * open up database and see what you have done :)
    // * validate request to allow customers with full name only, throw new ResponseStatusException
    // * create a method for updating customer, (id's should match)
    // * create a method for deleting customer
    // * create a method for saving a list of customers
    // * create a test for saving
    // * create a test for updating
    // * create a test for deleting

}
