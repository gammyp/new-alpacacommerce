package cf.alpaca202.Shopping.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cf.alpaca202.Shopping.models.Customer;
import cf.alpaca202.Shopping.repositories.CustomerRepository;

@Service
public class CustomerServices{
    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }


}