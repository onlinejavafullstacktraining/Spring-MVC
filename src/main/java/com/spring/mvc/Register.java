package com.spring.mvc;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

public class Register {
	private Long id;
	@Size(min=3,max=20, message="FirstName must be between 3 and 20 characters")
	private String firstName;
	@Size(min=3,max=20, message="LastName must be between 3 and 20 characters")
	private String lastName;
	@Pattern(regexp="^[A-Za-z0-9+_.-]+@(.+)$", message="Invalid Email Address")
	private String email;
	@Size(min=3,max=20, message="UserName must be between 3 and 20 characters")
	private String userName;
	@Size(min=3,max=20, message="Password must be between 3 and 20 characters")
	private String password;
	@Size(min=3,max=20, message="Confirm Password must be between 3 and 20 characters")
	private String confirmPassword;
	private MultipartFile upload;
	private byte[] image;
	private String base64;
	private Login login;
	
	
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}
	public String getBase64() {
		return base64;
	}
	public void setBase64(String base64) {
		this.base64 = base64;
	}
	
	
}
