package com.test;

import javax.swing.text.html.HTML;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private RequestConfiguration configuration;

	@Autowired
	private UserService service;

	// login and genrate token
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserDto users) {

		try {
			Users users2 = new Users();
			users2.setName("prajit");
			users2.setPass("prajit@123");

			if (users.getName().equals(users2.getName()) && users.getPass().equals(users2.getPass()) ) {
				UserDetails loadUserByUsername = service.loadUserByUsername(users.getName());

				String generateToken = configuration.generateToken(loadUserByUsername);

				return new ResponseEntity<>(generateToken, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("User inforamtion is not correct", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {

			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

}
