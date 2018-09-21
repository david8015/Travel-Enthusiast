package com.TravelEnthusiast2.Bean;

import javax.validation.constraints.*;

public class User {
	  private int userID;
      private String firstName;
      private String lastName;
      private String email;
      
      @NotNull
      @Size(min = 5, max = 14,
      message = "user name must be between {2} and {1}")
      private String userName;
      
      @NotNull
      @Size(min = 5,
      message = "password must be between higher than {1} characters")
      private String password;
     
	  private String country;
	  private int userType;
	  
	  
	  public User() {
	  }
		
	public User(int userID, String firstName, String lastName, String email, String userName, String password, String country, int userType) {
		super();
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.country = country;
		this.userType = userType;
	}
	

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}
}
