package com.saykar.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saykar.Model.Client;
import com.saykar.Model.Compte;
import com.saykar.Repository.ClientRepository;

@Service
public class ClientService extends Abstarctservices<Client> {
	@Autowired
	private ClientRepository Cr;

	@Override
	public Iterable<Client> findAll() {

		return Cr.findAll();
	}

	@Override
	public Optional<Client> findbyid(int id) {
		// TODO Auto-generated method stub
		return Cr.findById(id);
	}

	@Override
	public void Delete(int id) {
		Cr.deleteById(id);
	}

	@Override
	public Client update(Client client) {
		// TODO Auto-generated method stub
		return Cr.save(client);
	}

	@Override
	public Client create(Client client) {
		 client.setCompte(new Compte());
		return Cr.save(client);
	}

	public Client findByUsername(String username) {
		return Cr.findByUsername(username);
	}

}
