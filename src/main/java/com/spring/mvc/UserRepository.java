package com.spring.mvc;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public boolean saveUser(Register register) {
		Login login = new Login();
		login.setUserName(register.getUserName());
		login.setPassword(register.getPassword());
		login.setRegister(register);
		register.setLogin(login);
		Serializable serializable = hibernateTemplate.save(register);
		return Objects.nonNull(serializable) ? Boolean.TRUE : Boolean.FALSE;

	}

	public Login loadUserInfo(String userName) {
		@SuppressWarnings("unchecked")
		List<Login> find = (List<Login>) hibernateTemplate.find("from Login l where l.userName=?", userName);
		return !find.isEmpty() ? find.get(0) : null;
	}

}
