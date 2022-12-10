package com.dynamic.progress.service;

import com.dynamic.progress.entity.Customer;
import com.dynamic.progress.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public String deleteSingleCustomerService(Integer customerID) {
        try {
            customerRepository.deleteById(customerID);
        } catch (Exception e) {
            return "Can't delete.\n" + e.toString();
        }

        return "Successfully Deleted.";
    }

    public Customer updateSingleCustomerService(Integer customerID, Customer updatedCustomer) {
        Optional<Customer> customer = customerRepository.findById(customerID);

        customer.get().setName(updatedCustomer.getName());
        customer.get().setAge(updatedCustomer.getAge());

        if(customer.isPresent()) {
            return customerRepository.save(customer.get());
        } else {
            return null;
        }
    }
}
