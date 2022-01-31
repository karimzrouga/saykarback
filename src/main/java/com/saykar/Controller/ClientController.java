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

import com.saykar.Model.Client;
import com.saykar.Model.Compte;
import com.saykar.Services.ClientService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ClientController {
	@Autowired
	private ClientService cs;

	@GetMapping(path = "/Clientall")
	public @ResponseBody Iterable<Client> getAll() {
		return cs.findAll();
	}

	@GetMapping(path = "/Clienthello")
	public String test() {
		return "Client DONE";
	}

	@GetMapping(path = "/load/{username}")
	public Client login(@PathVariable String username) {
		return this.cs.findByUsername(username);
	}

	@GetMapping(value = "/Clientfind{fid}")
	public Optional<Client> findbyid(@PathVariable int fid) {
		Optional<Client> fc = cs.findbyid(fid);
		if (fc != null) {
			return fc;
		} else {
			return null;
		}
	}

	@PostMapping(path = { "/Clientadd" })
	private Client addcondidat(@RequestBody Client Client) {
		if (Client == null) {
			return null;
		} else

		{
			Compte c = new Compte();
			Client.setCompte(c);
			return cs.create(Client);

		}

	}

	@PutMapping(path = { "/Clientupdate" })
	private Client updatecondidat(@RequestBody Client medca) {
		return cs.update(medca);
	}

	@DeleteMapping(path = "/Clientdelete{id}")
	private void Deletecondidat(@PathVariable int id) {
		cs.Delete(id);

	}
}
