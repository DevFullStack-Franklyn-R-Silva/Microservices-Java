package com.github.hadesfranklyn.rest.service;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.github.hadesfranklyn.rest.model.Person;

@Service
public class PersonServices {
   
	private final AtomicLong counter = new AtomicLong();
	
	public Person findById(String id) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Franklyn");
		person.setLastName("Roberto");
		person.setAddress("Arapiraca - AL");
		person.setGender("Masculino");
		return person;
	}
}
