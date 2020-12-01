package tech.kitucode.Learn.web.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.kitucode.Learn.domain.Customer;
import tech.kitucode.Learn.repository.CustomerRepository;
import tech.kitucode.Learn.service.CustomerService;
import tech.kitucode.Learn.service.dto.CustomerDTO;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class CustomerResource {
    private final CustomerService customerService;
    private final CustomerRepository customerRepository;

    public CustomerResource(CustomerService customerService, CustomerRepository customerRepository) {
        this.customerService = customerService;
        this.customerRepository = customerRepository;
    }

    @PostMapping("/customers")
    public CustomerDTO create(@RequestBody CustomerDTO customerDTO){
        // call CustomerService to save the customer
        return customerService.save(customerDTO);
    }

}
