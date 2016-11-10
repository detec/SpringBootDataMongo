package sample.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import sample.domain.Customer;

/**
 * Spring Data repository extension.
 *
 * @author Andrii Duplyk
 *
 */
@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

	/**
	 *
	 * @param firstName
	 * @return
	 */
	public Customer findByFirstName(String firstName);

	/**
	 *
	 * @param lastName
	 * @return
	 */
	public List<Customer> findByLastName(String lastName);

	/**
	 *
	 * @param id
	 * @return
	 */
	public Customer findById(String id);

}
