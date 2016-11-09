package sample.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import sample.dao.CustomerRepository;
import sample.domain.Customer;

/**
 * Sample controller class to check application is alive.
 *
 * @author Andrii Duplyk
 *
 */
@EnableWebMvc
@RestController
public class SampleRest {

	@Autowired
	private CustomerRepository repository;

	@PostMapping
	ResponseEntity<Customer> saveCustomer(@RequestBody Customer entity) {
		Customer newEntity = repository.save(entity);
		return new ResponseEntity<>(newEntity, HttpStatus.CREATED);

	}

	@PutMapping
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

	/**
	 * Live test endpoint
	 *
	 * @return true as JSON
	 */
	@GetMapping("test")
	ResponseEntity<Boolean> testController() {
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
	}

	/**
	 * Endpoint to test LocalDateTime output, taht should be formatted as ISO
	 * date.
	 *
	 * @return wrapped entity
	 */
	@GetMapping("now")
	ResponseEntity<LocalDateTime> getNow() {
		return new ResponseEntity<>(LocalDateTime.now(), HttpStatus.OK);
	}
}
