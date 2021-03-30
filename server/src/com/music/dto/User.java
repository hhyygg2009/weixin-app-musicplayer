package com.music.dto;

public class User {
	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	public User(String name, String password, int age, String gender,String email, 
			String education, String interesting) {
		super();
		this.name = name;
		this.password = password;
		this.age = age;
		this.gender = gender;
		this.interesting = interesting;
		this.email = email;
		this.education = education;
	}



	private String name;
	private String password;
	private int age;
	private String gender;
	private String interesting;
	private String email;
	private String education;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getInteresting() {
		return interesting;
	}
	public void setInteresting(String interesting) {
		this.interesting = interesting;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}

	

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", age=" + age + ", gender=" + gender
				+ ", interesting=" + interesting + ", email=" + email + ", education=" + education + "]";
	}

}
