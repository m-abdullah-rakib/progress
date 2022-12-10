package com.dynamic.progress.controller;

import com.dynamic.progress.entity.Customer;
import com.dynamic.progress.repository.CustomerRepository;
import com.dynamic.progress.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vi/customer")
public class CustomerController {

    CustomerRepository customerRepository;
    CustomerService customerService;

    public CustomerController(CustomerRepository customerRepository, CustomerService customerService) {
        this.customerRepository = customerRepository;
        this.customerService = customerService;
    }

    @GetMapping(path = "/getAllCustomer")
    public List<Customer> getCustomer() {
        return customerRepository.findAll();
    }

    @PostMapping(path = "/addSingleCustomer")
    public Customer addSingleCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @DeleteMapping(path = "/deleteSingleCustomer/{customerID}")
    public String deleteSingleCustomer(@PathVariable("customerID") Integer customerID) {
        return customerService.deleteSingleCustomerService(customerID);
    }

    @PutMapping(path = "/updateSingleCustomer/{customerID}")
    public Customer updateSingleCustomer(@PathVariable("customerID") Integer customerID, @RequestBody Customer updatedCustomer) {
        return customerService.updateSingleCustomerService(customerID, updatedCustomer);
    }
}
