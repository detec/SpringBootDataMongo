package sample.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import sample.domain.Customer;

/**
 * @author Andrii Duplyk
 *
 */
@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

	public Customer findByFirstName(String firstName);

	public List<Customer> findByLastName(String lastName);

	public Customer findById(String id);

}
