package org.sab.bsm.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "locations")
public class Location extends _BaseModel {

	private static final long serialVersionUID = 5736416535890823971L;

	private String name;

	private String address;

	private String number;

	private Integer zip;

	private String city;

	private String country;

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public String getName() {
		return name;
	}

	public String getNumber() {
		return number;
	}

	public Integer getZip() {
		return zip;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}


}
