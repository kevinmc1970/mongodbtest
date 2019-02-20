package com.test.mongodbtest.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
	
	@Id
	private Integer id;
	public User(Integer id, String name, String team, long salary) {
		super();
		this.id = id;
		this.name = name;
		this.team = team;
		this.salary = salary;
	}
	private String name;
	private String team;
	private long salary;

}
