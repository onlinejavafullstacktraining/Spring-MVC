package com.spring.mvc;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private EmailService emailService;

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean saveUser(Register register) {
		 if(userRepository.saveUser(register)) {
			emailService.sendEmail(register);
			return true;
		}
		 return false;
	}
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean loadUserInfo(Login login) {
		Login validLogin=userRepository.loadUserInfo(login.getUserName());
		if(Objects.nonNull(validLogin))
			return Boolean.TRUE;
		else 
			return Boolean.FALSE;
		
	}
}
