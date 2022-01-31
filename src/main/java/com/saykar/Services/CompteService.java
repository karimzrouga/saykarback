package com.saykar.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saykar.Model.Compte;
import com.saykar.Repository.ComptreRepository;

@Service
public class CompteService extends Abstarctservices<Compte> {
	@Autowired
	private ComptreRepository CR;

	@Override
	public Iterable<Compte> findAll() {

		return CR.findAll();
	}

	@Override
	public Optional<Compte> findbyid(int id) {
		// TODO Auto-generated method stub
		return CR.findById(id);
	}

	@Override
	public void Delete(int id) {
		CR.deleteById(id);
	}

	@Override
	public Compte update(Compte compte) {
		// TODO Auto-generated method stub
		return CR.save(compte);
	}

	@Override
	public Compte create(Compte compte) {
		// TODO Auto-generated method stub
		return CR.save(compte);
	}

}
