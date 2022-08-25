package com.spring.mvc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.print.attribute.HashAttributeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Login login = userRepository.loadUserInfo(username);
		if (Objects.isNull(login))
			throw new UsernameNotFoundException(username);
		List<GrantedAuthority> authorities = buildUserAuthority(login.getRoles());
		return buildUserForAuthentication(login, authorities);

	}

	private UserDetails buildUserForAuthentication(Login login, List<GrantedAuthority> authorities) {

		return new User(login.getUserName(), login.getPassword(), login.isValidFlag(), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<Role> roles) {
		List<GrantedAuthority> rolesList = new ArrayList<>();
		roles.forEach(role -> rolesList.add(new SimpleGrantedAuthority(role.getRole())));
		return rolesList;
	}

}
