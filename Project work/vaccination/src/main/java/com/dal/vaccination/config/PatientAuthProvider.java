package com.dal.vaccination.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.dal.vaccination.entity.Patient;
import com.dal.vaccination.repo.PatientRepo;

import com.dal.vaccination.repo.PatientRepo;

@Component
public class PatientAuthProvider implements AuthenticationProvider {
	
	@Autowired
	PatientRepo patientRepo;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String pwd = authentication.getCredentials().toString();
		Patient patient = patientRepo.findByPatientName(username);System.out.println("Found Patient object" + patient);
		if (patient == null) {
			throw new StackOverflowError("No user got registered");
		} else if (pwd.equals(patient.getPatientPwd())) {
			return new UsernamePasswordAuthenticationToken(username, pwd, null);
		} else {
			System.out.println("I am a bad credentails");
			throw new StackOverflowError("Invalid Password");
		}
	}
	@Override
	public boolean supports(Class<?> authentication) {		
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
