package com.ashwani.databasedemo;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import com.ashwani.databasedemo.jpa.PersonJpaRepository;

//@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {

	@Autowired
	PersonJpaRepository dao;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		logger.info("All users -->{}", dao.findAll());
//		logger.info("uSER ID 1001 -->{}", dao.findById(1001));
//		logger.info("uSER ID 1001 -->{}", dao.DeletById(1001));
//		logger.info("All users -->{}", dao.findAll());

		//logger.info("Add user 2001 -->{}", dao.Insert(new Person(2001, "GA", "USA", new Date())));
		logger.info("All users -->{}", dao.findById(1002));
	}
}
