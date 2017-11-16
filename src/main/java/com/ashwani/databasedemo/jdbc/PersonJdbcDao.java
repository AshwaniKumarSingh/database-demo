package com.ashwani.databasedemo.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ashwani.databasedemo.entity.Person;

@Repository
public class PersonJdbcDao {

	// select * from table

	@Autowired
	JdbcTemplate jdbctemplate;

	class PersonRowMapper implements RowMapper<Person> {

		@Override
		public Person mapRow(ResultSet rs, int arg1) throws SQLException {
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirthDate(rs.getDate("target_date"));

			return person;
		}
	}

	public List<Person> findAll() {

		return jdbctemplate.query("select * from person", new PersonRowMapper());
	}

	public Person findById(int id) {
		return jdbctemplate.queryForObject("select * from person where id =?", new Object[] { id },
				new BeanPropertyRowMapper<Person>(Person.class));
	}

	public int DeletById(int id) {
		return jdbctemplate.update("delete  from person where id =?", new Object[] { id });
	}

	public int Insert(Person person) {
		return jdbctemplate.update("insert into person (id, name, location, birth_date) values(?,?,?,?)",
				new Object[] { person.getId(), person.getName(), person.getLocation(),
						new Timestamp(person.getBirthDate().getTime()) });

	}

}
