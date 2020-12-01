package tech.kitucode.Learn.service.mapper;

import org.springframework.stereotype.Service;
import tech.kitucode.Learn.domain.Customer;
import tech.kitucode.Learn.service.dto.CustomerDTO;

@Service
public class CustomerMapper {
    public Customer toEntity(CustomerDTO customerDTO){
        if(customerDTO==null){
            return null;
        }

        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        return customer;
    }

    public CustomerDTO toDTO(Customer customer){
        if(customer==null){
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        return customerDTO;
    }
}
