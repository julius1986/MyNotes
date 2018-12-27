package com.mynotes.app.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class EncoderForPass {
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public EncoderForPass() {
		if (this.bCryptPasswordEncoder == null) {
			this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
		}
		
	}

	public static void main(String[] args) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String password = "1234";
		String hashedPassword = bCryptPasswordEncoder.encode(password);
		System.out.println(hashedPassword);
	}
	
	public String codePassword(String password) {
		String hashedPassword = bCryptPasswordEncoder.encode(password);
		return hashedPassword;
	}
	
	public BCryptPasswordEncoder getBCryptPasswordEncoder () {
		return bCryptPasswordEncoder;
	}
	

}
