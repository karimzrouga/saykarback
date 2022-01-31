package com.saykar.Controller;

import java.util.ArrayList;
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

import com.saykar.Model.Client;
import com.saykar.Model.Entreprise;
import com.saykar.Model.Spot;
import com.saykar.Services.ClientService;
import com.saykar.Services.EntrepriseService;
import com.saykar.Services.SpotService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class SpotController {
	@Autowired
	private SpotService cs;
	@Autowired
	private EntrepriseService ES;
	@Autowired
	private ClientService cse;

	@GetMapping(path = "/Spotall")
	public @ResponseBody Iterable<Spot> getAll() {
		Iterable<Spot> list = cs.findAll();
		ArrayList<Spot> newlist = new ArrayList<>();
		for (Spot spot : list) {
			spot.setNameEntreprise(spot.getEntreprise().getCompanyname());
			spot.setImage(spot.getEntreprise().getImage());
			newlist.add(spot);
		}
		return newlist;
	}

	@GetMapping(path = "/Spothello")
	public String test() {
		return "Spot DONE";
	}
	@GetMapping(path = "/Spotclient/{id}")
	public List<Client>  spotclient(@PathVariable int id) {
		return this.cs.findbyid(id).get().getClients();
	}

	@GetMapping(value = "/Spotfind{fid}")
	public Optional<Spot> findbyid(@PathVariable int fid) {
		Optional<Spot> fc = cs.findbyid(fid);
		if (fc != null) {
			return fc;
		} else {
			return null;
		}
	}

	@PostMapping(path = { "/Spotadd/{fid}" })
	private Spot addspot(@RequestBody Spot Spot, @PathVariable int fid) {
		if (Spot == null) {
			return null;
		} else

		{
			Optional<Entreprise> ent = this.ES.findbyid(fid);
			Spot.setEntreprise(ent.get());
			return cs.create(Spot);

		}

	}

	@GetMapping(path = { "/markvu/{fid}/{id}" })
	private boolean markvu(@PathVariable int id, @PathVariable int fid) {
		Client c = this.cse.findbyid(fid).get();
		Spot s = this.cs.findbyid(id).get();
		List<Spot> l = c.getSpotes();
		if (l.indexOf(s) == -1) {
			l.add(s);
			c.setSpotes(l);
			this.cse.create(c);
			return true;
		}
		return false;

	}

	@PutMapping(path = { "/Spotupdate" })
	private Spot updatespot(@RequestBody Spot spot) {
		return cs.update(spot);
	}

	@PostMapping(path = { "/getentreprise" })
	private int getentreprise(@RequestBody Spot spot) {
		return cs.findbyid(spot.getIdSpot()).get().getEntreprise().getIdEntreprise();
	}

	@DeleteMapping(path = "/Spotdelete{id}")
	private void Deletespot(@PathVariable int id) {
		cs.Delete(id);

	}
}
