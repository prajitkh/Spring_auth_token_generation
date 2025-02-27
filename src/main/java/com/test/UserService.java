package com.test;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class UserService  implements UserDetailsService{

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		if ("prajit".equals(username)) {
			return new User("prajit", "prajit@123",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}
