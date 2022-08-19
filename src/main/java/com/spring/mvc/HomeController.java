package com.spring.mvc;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String homePage() {
		System.out.println("homePage method is calling...");
		return "home";
	}

	@RequestMapping("/login")
	public ModelAndView loadLoginPage() {
		return new ModelAndView("login").addObject("login", new Login());
	}

	@RequestMapping("/register")
	public ModelAndView loadRegisterPage() {
		return new ModelAndView("register").addObject("register", new Register());
	}

	@RequestMapping("/loginProcess")
	public ModelAndView loginProcess(@Valid Login login, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ModelAndView("login")
					.addObject("error", "Login failed try one more time");
		}
		boolean isValidUser=userService.loadUserInfo(login);
		if (isValidUser)
			return new ModelAndView("home")
					.addObject("registerMessage", "Successfully-Login");
		else
			return new ModelAndView("login")
					.addObject("error", "Login failed try one more time");
		
	}

	@RequestMapping("/registerProcess")
	public ModelAndView registerProcess(@Valid Register register, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ModelAndView("register")
					.addObject("error", "Registration failed try one more time");
		}
		boolean saveUser = userService.saveUser(register);
		if (saveUser)
			return new ModelAndView("home")
					.addObject("registerMessage", "Successfully- Register");
		else
			return new ModelAndView("register")
					.addObject("error", "Registration failed try one more time");
	}

}
