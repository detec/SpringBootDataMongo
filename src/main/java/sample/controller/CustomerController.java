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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import sample.dao.CustomerRepository;
import sample.domain.Customer;

/**
 * Endpoint for sample class {@link Customer}
 *
 * @author Andrii Duplyk
 *
 */
@RestController
@RequestMapping(value = "customers")
public class CustomerController {

	@Autowired
	private CustomerRepository repository;

	@ApiOperation(value = "Customer save", notes = "Saves a new customer")
	@PostMapping
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created", response = Customer.class) })
	ResponseEntity<Customer> saveCustomer(
			@ApiParam(value = "New customer body", required = true) @RequestBody Customer entity) {
		Customer newEntity = repository.save(entity);
		return new ResponseEntity<>(newEntity, HttpStatus.CREATED);

	}

	@ApiOperation(value = "Customer update", notes = "Updates an existing customer by id")
	@PutMapping("{id}")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Customer.class) })
	ResponseEntity<Customer> updateCustomer(
			@ApiParam(value = "Updated customer body", required = true) @RequestBody Customer entity) {
		Customer newEntity = repository.save(entity);
		return new ResponseEntity<>(newEntity, HttpStatus.OK);
	}

	@ApiOperation(value = "Customer retrieval", notes = "Gets an existing customer by id")
	@GetMapping("{id}")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Customer.class),
			@ApiResponse(code = 404, message = "No customer found") })
	ResponseEntity<Customer> getCustomerById(
			@ApiParam(value = "Customer id", required = true) @PathVariable String id) {
		Customer newEntity = repository.findById(id);
		if (newEntity != null) {
			return new ResponseEntity<>(newEntity, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@ApiOperation(value = "Customer removal", notes = "Removes an existing customer by id from database")
	@DeleteMapping("{id}")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Removed") })
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
