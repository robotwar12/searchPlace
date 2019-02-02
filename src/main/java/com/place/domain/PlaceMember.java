package com.place.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PlaceMember {

	@Id
	@GeneratedValue
	private Long memberNumber;

	@Column
	private String id;

	@Column
	private String password;

	public PlaceMember() {
		super();
	}

	public PlaceMember(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
