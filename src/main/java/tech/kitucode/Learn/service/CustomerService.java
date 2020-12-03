package tech.kitucode.Learn.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tech.kitucode.Learn.domain.Customer;
import tech.kitucode.Learn.repository.CustomerRepository;
import tech.kitucode.Learn.service.dto.CustomerDTO;
import tech.kitucode.Learn.service.mapper.CustomerMapper;


@Service
public class CustomerService {
    private final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        // wire
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerDTO save(CustomerDTO customerDTO){

        logger.debug("Request to save customer : {}",customerDTO);

        // convert dto to entity for saving
        Customer customer = customerMapper.toEntity(customerDTO);

        //save the entity
        customer = customerRepository.save(customer);

        // covert entity to dto and return it.
        return customerMapper.toDTO(customer);
    }

}
