package com.mynotes.app.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncoderForPass {

	public static void main(String[] args) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String password = "user3";
		String hashedPassword = bCryptPasswordEncoder.encode(password);
		System.out.println(hashedPassword);
	}

}
