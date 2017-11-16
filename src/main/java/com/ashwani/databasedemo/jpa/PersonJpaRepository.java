package com.ashwani.databasedemo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ashwani.databasedemo.entity.Person;

//Transactions--

@Repository
@Transactional
public class PersonJpaRepository {

	// connect to the database
	
	@PersistenceContext
	EntityManager entityManger;

	public Person findById(int id) {
		// Entity Manager managing the entity

		return entityManger.find(Person.class, id);

	}
	public void DeleteById(int id) {
	Person person = findById(id);
			entityManger.remove(person);;

	}
	
	
	public Person Update(Person person)
	{
		return entityManger.merge(person);
		
	}
	public Person Insert(Person person)
	{
		return entityManger.merge(person);
		
	}
	
	
	public List<Person> findAll()
	{
		TypedQuery<Person> namedQuery = entityManger.createNamedQuery("find_all_person", Person.class);
		return namedQuery.getResultList();
	}

}
