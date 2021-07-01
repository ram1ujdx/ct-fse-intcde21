package com.cts.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.microservice.dto.JwtToken;
import com.cts.microservice.dto.UserCredentials;
import com.cts.microservice.util.JwtUtil;

@RestController
public class LoginContrller {
	
	@Autowired
	AuthenticationManager authMgr;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	UserDetailsService userDetailsService;

	@PostMapping("/login")
	public JwtToken generateToken(@RequestBody UserCredentials cred) {
		authMgr.authenticate(new UsernamePasswordAuthenticationToken(cred.getUsername(), cred.getPassword()));
		UserDetails userDetails=userDetailsService.loadUserByUsername(cred.getUsername());
		String jwt=jwtUtil.generateToken(userDetails);
		JwtToken jwtToken=new JwtToken();
		jwtToken.setJwtToken(jwt);
		return jwtToken;
		
	}
	
	
}
