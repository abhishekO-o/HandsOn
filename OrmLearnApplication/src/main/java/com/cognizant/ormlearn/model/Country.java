package com.cognizant.ormlearn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Specifies that this is mapped to a database table
@Table(name = "country") // Mapped to that country table of ormlearn database in the sql
public class Country {
	@Id // This is the primary key
	@Column(name = "co_code")
	private String co_code;

	@Column(name = "co_name")
	private String co_name;

	// Generate getters and setters
	public String getCo_code() {
		return co_code;
	}

	public void setCo_code(String co_code) {
		this.co_code = co_code;
	}

	public String getCo_name() {
		return co_name;
	}

	public void setCo_name(String co_name) {
		this.co_name = co_name;
	}
	// Generate toString()

	@Override
	public String toString() {
		return "Country [co_code=" + co_code + ", co_name=" + co_name + "]";
	}
}
