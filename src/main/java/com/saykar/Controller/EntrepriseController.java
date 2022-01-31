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

import com.saykar.Model.Entreprise;
import com.saykar.Services.EntrepriseService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class EntrepriseController {
	@Autowired
	private EntrepriseService cs;

	@GetMapping(path = "/Entrepriseall")
	public @ResponseBody Iterable<Entreprise> getAll() {
		return cs.findAll();
	}

	@GetMapping(path = "/Entreprisehello")
	public String test() {
		return "Entreprise DONE";
	}

	@GetMapping(value = "/Entreprisefind{fid}")
	public Optional<Entreprise> findbyid(@PathVariable int fid) {
		Optional<Entreprise> fc = cs.findbyid(fid);
		if (fc != null) {
			return fc;
		} else {
			return null;
		}
	}

	@PostMapping(path = { "/Entrepriseadd" })
	private Entreprise addcondidat(@RequestBody Entreprise Entreprise) {
		if (Entreprise == null) {
			return null;
		} else

		{
			return cs.create(Entreprise);

		}

	}

	@PutMapping(path = { "/Entrepriseupdate" })
	private Entreprise updatecondidat(@RequestBody Entreprise medca) {
		return cs.update(medca);
	}

	@DeleteMapping(path = "/Entreprisedelete{id}")
	private void Deletecondidat(@PathVariable int id) {
		cs.Delete(id);

	}
	@GetMapping(path = "/loadent/{username}")
	public Entreprise login(@PathVariable String username) {
		return this.cs.findByUsername(username);
	}
}
