package sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import sample.dao.CustomerRepository;
import sample.domain.Customer;

/**
 * Endpoint for sample class {@link Customer}
 *
 * @author Andrii Duplyk
 *
 */
@EnableWebMvc
@RestController
@RequestMapping(value = "customers")
public class CustomerController {

	@Autowired
	private CustomerRepository repository;

	@PostMapping
	ResponseEntity<Customer> saveCustomer(@RequestBody Customer entity) {
		Customer newEntity = repository.save(entity);
		return new ResponseEntity<>(newEntity, HttpStatus.CREATED);

	}

	@PutMapping("{id}")
	ResponseEntity<Customer> updateCustomer(@RequestBody Customer entity) {
		Customer newEntity = repository.save(entity);
		return new ResponseEntity<>(newEntity, HttpStatus.OK);
	}

	@GetMapping("{id}")
	ResponseEntity<Customer> getCustomerById(@PathVariable String id) {
		Customer newEntity = repository.findById(id);
		if (newEntity != null) {
			return new ResponseEntity<>(newEntity, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("{id}")
	ResponseEntity<Customer> deleteCustomer(@PathVariable String id) {
		Customer entity = repository.findById(id);
		if (entity == null) {
			throw new IllegalArgumentException("Customer not found with id: " + id);
		}

		repository.delete(entity);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

	@GetMapping("/filter/{lastName}")
	ResponseEntity<List<Customer>> findByLastName(@PathVariable String lastName) {

		List<Customer> customerList = repository.findByLastName(lastName);
		return new ResponseEntity<>(customerList, HttpStatus.OK);
	}

}
