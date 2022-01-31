package com.saykar.Config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.saykar.Model.Client;
import com.saykar.Model.Compte;
import com.saykar.Model.Entreprise;
import com.saykar.Repository.ClientRepository;
import com.saykar.Repository.EntrepriseRepository;

@Service
public class MYUserDetailsService implements UserDetailsService {
	@Autowired
	private ClientRepository Cr;
	@Autowired
	private EntrepriseRepository Er;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (Cr.findAll().isEmpty())
		{
			Cr.save(new Client (0, "admin", "admin", "admin", "admin.png", "", username, null, 0, new Compte() ));
		}
		System.out.println(username.indexOf("company") >0);
		if (username.indexOf("company") >0) {
			System.out.println("company");
			Entreprise ent = Er.findByUsername(username);
			if (ent != null) {

				return new User(ent.getUsername(), ent.getPassword(), new ArrayList<>());
			}

		} else {
			System.out.println("client");
			Client user = Cr.findByUsername(username);
			if (user != null) {

				return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
			}
		}
		return null;

	}

}
