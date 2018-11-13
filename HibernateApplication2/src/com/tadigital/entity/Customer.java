package com.tadigital.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name = "user_info")
@DynamicInsert(value = true)
public class Customer {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	@Column(name="name")
	String custName;
	@Column(name="username")
	String username;
	@Column(name="password")
	String password;
	@Column(name="profile")
	String profilePic;
	
	public Customer() {
	}

	public Customer(int id, String custName, String username, String password, String profilePic) {
		this.id = id;
		this.custName = custName;
		this.username = username;
		this.password = password;
		this.profilePic = profilePic;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", custName=" + custName + ", username=" + username + ", password=" + password
				+ ", profilePic=" + profilePic + "]";
	}
	
	
}
