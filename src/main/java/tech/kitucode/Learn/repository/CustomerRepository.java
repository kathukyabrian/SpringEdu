package tech.kitucode.Learn.repository;

import org.springframework.data.repository.CrudRepository;
import tech.kitucode.Learn.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
}
