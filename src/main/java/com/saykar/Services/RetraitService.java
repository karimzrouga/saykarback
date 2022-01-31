package com.saykar.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saykar.Model.Retrait;
import com.saykar.Repository.RetraitRepository;

@Service
public class RetraitService extends Abstarctservices<Retrait> {
	@Autowired
	private RetraitRepository RR;

	@Override
	public Iterable<Retrait> findAll() {
		// TODO Auto-generated method stub
		return RR.findAll();
	}

	@Override
	public Optional<Retrait> findbyid(int id) {
		// TODO Auto-generated method stub
		return RR.findById(id);
	}

	@Override
	public void Delete(int id) {
		// TODO Auto-generated method stub
		RR.deleteById(id);
	}

	@Override
	public Retrait update(Retrait retrait) {
		// TODO Auto-generated method stub
		return RR.save(retrait);
	}

	@Override
	public Retrait create(Retrait retrait) {
		// TODO Auto-generated method stub
		return RR.save(retrait);
	}

}
