package com.springapp.service;

import com.springapp.model.Person;

public interface PersonService{

public Person getRandom();
public Person getById(Long id);
public void save(Person person);

}
