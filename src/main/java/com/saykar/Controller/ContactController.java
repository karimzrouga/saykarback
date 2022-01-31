package com.saykar.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.saykar.Model.Contact;
import com.saykar.Services.ContactService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ContactController {
	@Autowired
	private ContactService cs;

	@GetMapping(path = "/Contactall")
	public @ResponseBody Iterable<Contact> getAll() {
		return cs.findAll();
	}

	@GetMapping(path = "/Contacthello")
	public String test() {
		return "Contact DONE";
	}

	@GetMapping(value = "/Contactfind{fid}")
	public Optional<Contact> findbyid(@PathVariable int fid) {
		Optional<Contact> fc = cs.findbyid(fid);
		if (fc != null) {
			return fc;
		} else {
			return null;
		}
	}

	@PostMapping(path = { "/Contactadd" })
	private Contact addcontact(@RequestBody Contact Contact) {
		if (Contact == null) {
			return null;
		} else

		{

			return cs.create(Contact);

		}

	}

	@PutMapping(path = { "/Contactupdate" })
	private Contact updatecontact(@RequestBody Contact medca) {
		return cs.update(medca);
	}

	@DeleteMapping(path = "/Contactdelete{id}")
	private void Deletecontact(@PathVariable int id) {
		cs.Delete(id);

	}
}
