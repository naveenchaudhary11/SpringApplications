package com.tadigital.entity;



public class Customer {
	
	int id;
	String custName;
	String username;
	String password;
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
