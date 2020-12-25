package tech.kitucode.Learn.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger log = LoggerFactory.getLogger(CustomerResource.class);

    public CustomerResource(CustomerService customerService, CustomerRepository customerRepository) {
        this.customerService = customerService;
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customers")
    public List<CustomerDTO> getAll(){
        log.debug("REST request to get all customers");
        return customerService.getAll();
    }

    @GetMapping("/customers/{id}")
    public CustomerDTO findById(@PathVariable Long id){
        log.debug("REST request to find customer with id : {}",id);
        return customerService.findOne(id);
    }

    @DeleteMapping("/customers/{id}")
    public void deleteById(@PathVariable Long id){
        log.debug("REST request to delete customer with id : {}",id);
        customerService.delete(id);
    }

    @PostMapping("/customers")
    public CustomerDTO create(@RequestBody CustomerDTO customerDTO){
        log.debug("REST request to save customer : {} ",customerDTO);
        // check if there is id in request body
        if(customerDTO.getId()!=null){
            // if there is an id, just update
            update(customerDTO);
        }
        // if there is no id call CustomerService to fresh save the customer
        return customerService.save(customerDTO);
    }

    @PutMapping("/customers")
    public CustomerDTO update(@RequestBody CustomerDTO customerDTO){
        // If there's no id, do a fresh save
        if(customerDTO.getId()==null){
            log.debug("REST request to fresh save customer", customerDTO);
            create(customerDTO);
        }

        // call CustomerService to update customer
        log.debug("REST request to update customer",customerDTO);
        return customerService.save(customerDTO);
    }

}
