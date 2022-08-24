package com.spring.mvc;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Login login = repository.loadUserInfo(username);
		if (login == null) {
			throw new UsernameNotFoundException(username);
		}
		List<GrantedAuthority> authorities = buildUserAuthority(login.getRoles());

		return buildUserForAuthentication(login, authorities);
	}

	private org.springframework.security.core.userdetails.User buildUserForAuthentication(Login login,
			List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(login.getUserName(), login.getPassword(),
				Boolean.valueOf(login.getValidFlag()), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<Role> roles) {
		Set<GrantedAuthority> setAuths = new HashSet<>();
		roles.forEach(role -> setAuths.add(new SimpleGrantedAuthority(role.getRole())));
		return setAuths.stream().collect(Collectors.toList());
	}

}
