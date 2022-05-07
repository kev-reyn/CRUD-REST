package com.example.crudrest.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudrest.model.Customer;
import com.example.crudrest.repository.CustomerRepository;

@RestController
@RequestMapping(value = "/customer")
public class AppRestController {

	@Autowired
	private CustomerRepository repo;
	
	@GetMapping("")
	public List<Customer> selectAll(){
		return repo.findAll();
	}
	
	@PostMapping
	public void insert(@RequestBody Customer customer) {
		repo.save(customer);
	}

	@PutMapping
	public void modify(@RequestBody Customer customer) {
		repo.save(customer);
	}
	
	@DeleteMapping
	public void delete(@PathVariable("id") long id) {
		repo.deleteById(id);;
	}
	
	@GetMapping("/{id}")
	public Optional<Customer> getSpecificCustomer(@PathVariable long id){
		return repo.findById(id);
	}
	
	@GetMapping("/name/{name}")
	public List<Customer> searchByFirstName(@PathVariable String name){
		return repo.findByName(name);
	}
	
	@GetMapping("/sname/{sname}")
	public List<Customer> searchBySname(@PathVariable String sname){
		return repo.findBySname(sname);
	}
	
}
