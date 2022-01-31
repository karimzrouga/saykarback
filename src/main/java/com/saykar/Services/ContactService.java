package com.saykar.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saykar.Model.Contact;
import com.saykar.Repository.ContactRepository;

@Service
public class ContactService extends Abstarctservices<Contact> {
	@Autowired
	private ContactRepository CR;

	@Override
	public Iterable<Contact> findAll() {

		return CR.findAll();
	}

	@Override
	public Optional<Contact> findbyid(int id) {
		// TODO Auto-generated method stub
		return CR.findById(id);
	}

	@Override
	public void Delete(int id) {
		CR.deleteById(id);
	}

	@Override
	public Contact update(Contact Contact) {
		// TODO Auto-generated method stub
		return CR.save(Contact);
	}

	@Override
	public Contact create(Contact Contact) {
		// TODO Auto-generated method stub
		return CR.save(Contact);
	}

}
