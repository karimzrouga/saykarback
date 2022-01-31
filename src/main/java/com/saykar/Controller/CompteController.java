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

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class CompteController {
	@Autowired
	private CompteService cs;

	@GetMapping(path = "/Compteall")
	public @ResponseBody Iterable<Compte> getAll() {
		return cs.findAll();
	}

	@GetMapping(path = "/Comptehello")
	public String test() {
		return "Compte DONE";
	}

	@GetMapping(value = "/Comptefind{fid}")
	public Optional<Compte> findbyid(@PathVariable int fid) {
		Optional<Compte> fc = cs.findbyid(fid);
		if (fc != null) {
			return fc;
		} else {
			return null;
		}
	}

	@GetMapping(value = "/Compteretrait{fid}")
	public List<Retrait> Getcompteretrait(@PathVariable int fid) {
		Optional<Compte> fc = cs.findbyid(fid);
		if (fc != null) {
			return fc.get().getRetrait();
		} else {
			return null;
		}
	}

	@PostMapping(path = { "/Compteadd" })
	private Compte addcondidat(@RequestBody Compte Compte) {
		if (Compte == null) {
			return null;
		} else

		{
			return cs.create(Compte);

		}

	}

	@PutMapping(path = { "/Compteupdate" })
	private Compte updatecondidat(@RequestBody Compte medca) {
		return cs.update(medca);
	}

	@DeleteMapping(path = "/Comptedelete{id}")
	private void Deletecondidat(@PathVariable int id) {
		cs.Delete(id);

	}
}
