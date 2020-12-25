package tech.kitucode.Learn.service.mapper;

import org.springframework.stereotype.Service;
import tech.kitucode.Learn.domain.Customer;
import tech.kitucode.Learn.service.dto.CustomerDTO;

import java.util.ArrayList;
import java.util.List;

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

    public List<CustomerDTO> toDTO(List<Customer> customers){
        // instantiate an array list to store the CustomerDTOs
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        if(customers!=null){
            // loop through each customer, convert to DTO and add to the array list
            for(Customer customer:customers){
                customerDTOList.add(this.toDTO(customer));
            }
        }
        return customerDTOList;
    }
}
