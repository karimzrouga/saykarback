package com.saykar.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saykar.Model.Entreprise;
import com.saykar.Repository.EntrepriseRepository;

@Service
public class EntrepriseService extends Abstarctservices<Entreprise> {
	@Autowired
	private EntrepriseRepository ER;

	@Override
	public Iterable<Entreprise> findAll() {
		// TODO Auto-generated method stub
		return ER.findAll();
	}

	@Override
	public Optional<Entreprise> findbyid(int id) {
		// TODO Auto-generated method stub
		return ER.findById(id); 
	}

	@Override
	public void Delete(int id) {
		// TODO Auto-generated method stub
		ER.deleteById(id);
	}

	@Override
	public Entreprise update(Entreprise entreprise) {
		// TODO Auto-generated method stub
		return ER.save(entreprise);
	}

	@Override
	public Entreprise create(Entreprise entreprise) {
		// TODO Auto-generated method stub
		return ER.save(entreprise);
	}

	public Entreprise findByUsername(String username) {
		
		return this.ER.findByUsername(username);
	}

}
