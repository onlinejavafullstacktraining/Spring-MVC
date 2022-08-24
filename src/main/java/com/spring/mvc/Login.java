package com.spring.mvc;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.validator.constraints.NotEmpty;

public class Login implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 20154789654L;
	private Long id;
	@NotEmpty
	private String userName;
	@NotEmpty
	private String password;
	private String validFlag;
	private Set<Role> roles = new HashSet<Role>();
	private Register register;
	
	
	public Register getRegister() {
		return register;
	}
	public void setRegister(Register register) {
		this.register = register;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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

	public String getValidFlag() {
		return validFlag;
	}
	public void setValidFlag(String validFlag) {
		this.validFlag = validFlag;
	}
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
	
}
