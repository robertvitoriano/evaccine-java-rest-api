package br.com.robertvitoriano.backendfullstackweek.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.robertvitoriano.backendfullstackweek.domain.Person;
import br.com.robertvitoriano.backendfullstackweek.repository.PersonRepository;

@RestController
@RequestMapping("/people")
public class PersonController {
	
	@Autowired
	private PersonRepository personRepository;
	@GetMapping
	public List<Person> listAll(){
		
		return personRepository.findAll();
		
	}
	
	@PostMapping
	public Person registerPerson (@RequestBody Person person) {
		
	  Person savedEntity = 	personRepository.save(person);
		
	 return savedEntity;
		
	}
	@PutMapping("{code}")
	public  Person updatePerson( @PathVariable("code") Long code, @RequestBody Person person )  {
		
		
	 return  personRepository.findById(code).map( personElement -> {

		personElement.setCpf(person.getCpf());
		personElement.setBirthdate(person.getBirthdate());
		personElement.setName(person.getName());
		personElement.setTelephone(person.getTelephone());
		
		Person updatedPerson = personRepository.save(personElement);
		
		  return updatedPerson;
		  
		}).orElse(null);
	
	 
	}
	@GetMapping("{code}")
	public Person getByCode(@PathVariable Long code) {
		
	Person person = personRepository.findById(code).orElse(null);
	
			return person;
	}
	
	@DeleteMapping("{code}")

	public Person delete(@PathVariable Long code) {
		Person person = personRepository.findById(code).orElse(null);

		personRepository.deleteById(code);
		
		
		return person;
		
		
		
	}
	

}
