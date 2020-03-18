package com.boot.ms.InitialDemo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Greeting {

	@Id
	private Integer id;
	private String saying;

	public Greeting() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Greeting(Integer id, String saying) {
		super();
		this.id = id;
		this.saying = saying;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSaying() {
		return saying;
	}

	public void setSaying(String saying) {
		this.saying = saying;
	}

}
