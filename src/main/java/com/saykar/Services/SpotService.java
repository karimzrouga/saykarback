package com.saykar.Services;


import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saykar.Model.Spot;
import com.saykar.Repository.SpotRepository;

@Service
public class SpotService extends Abstarctservices<Spot> {
	@Autowired
	private SpotRepository Sp;

	@Override
	public Iterable<Spot> findAll() {
		// TODO Auto-generated method stub
		return Sp.findAll();
	}

	@Override
	public Optional<Spot> findbyid(int id) {
		// TODO Auto-generated method stub
		return Sp.findById(id);
	}
	

	@Override
	public void Delete(int id) {
		// TODO Auto-generated method stub
		Sp.deleteById(id); 
	}

	@Override
	public Spot update(Spot spot) {
		// TODO Auto-generated method stub
		return Sp.save(spot);
	}

	@Override
	public Spot create(Spot spot) {
		// TODO Auto-generated method stub
		LocalDate localDate = LocalDate.now();
		spot.setDate(localDate);
		return Sp.save(spot); 
	}

}
