package com.saykar.Controller;

import java.util.List;
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

import com.saykar.Model.Compte;
import com.saykar.Model.Retrait;
import com.saykar.Services.CompteService;
import com.saykar.Services.RetraitService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class RetraitController {
	@Autowired
	private RetraitService rs;
	@Autowired
	private CompteService cs;

	@GetMapping(path = "/Retraitall")
	public @ResponseBody Iterable<Retrait> getAll() {
		return rs.findAll();
	}

	@GetMapping(path = "/Retraithello")
	public String test() {
		return "Retrait DONE";
	}

	@GetMapping(value = "/Retraitfind{fid}")
	public Optional<Retrait> findbyid(@PathVariable int fid) {
		Optional<Retrait> fc = rs.findbyid(fid);
		if (fc != null) {
			return fc;
		} else {
			return null;
		}
	}

	@PostMapping(path = { "/Retraitadd/{id}" })
	private Retrait addretrait(@RequestBody Retrait Retrait, @PathVariable int id) {
		if (Retrait == null) {
			return null;
		} else

		{

			Compte compte = this.cs.findbyid(id).get();
			if (compte != null) {
				List<com.saykar.Model.Retrait> l = compte.getRetrait();
				l.add(Retrait);
				compte.setRetrait(l);
				this.cs.create(compte);
				return Retrait;
			}
			return null;

		}

	}

	@PutMapping(path = { "/Retraitupdate" })
	private Retrait updateretrait(@RequestBody Retrait medca) {
		return rs.update(medca);
	}

	@DeleteMapping(path = "/Retraitdelete{id}")
	private void Deleteretrait(@PathVariable int id) {
		rs.Delete(id);

	}
}
