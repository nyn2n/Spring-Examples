/**
 * Copyright NEWFOUND SYSTEMS to Present
 * All Rights Reserved
 */
package com.newfound.rest.server.service;

import com.newfound.rest.server.constants.Gender;
import com.newfound.rest.server.model.PersonList;

public interface PersonDaoService {

	/**
	 * Add Person(s) at Init
	 */
	void init();

	/**
	 * Find All Persons
	 * 
	 * @return
	 */
	PersonList findAllPersons();

	/**
	 * Find Person
	 * 
	 * @param id
	 * @return
	 */
	PersonList findPersonById(Integer id);

	/**
	 * Find Person(s) by First Name
	 * 
	 * @param firstName
	 * @return
	 */
	PersonList findPersonByFirstName(String firstName);

	/**
	 * Find Person(s) by Gender
	 * 
	 * @param gender
	 * @return
	 */
	PersonList findPersonByGender(Gender gender);

	/**
	 * Create Person
	 * 
	 * @return
	 */
	PersonList createPerson();

	/**
	 * Delete Person
	 * 
	 * @param id
	 * @return
	 */
	PersonList deletePerson(Integer id);

	/**
	 * Update Person
	 * 
	 * @param id
	 * @param newSalary
	 * @return
	 */
	PersonList updatePerson(Integer id, Integer newSalary);
}
