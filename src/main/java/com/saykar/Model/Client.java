package com.saykar.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Client")
public class Client   {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Idclient;
	private String username;
	private String fullname;
	private String password;
	private String image;
	private String Email;
	private String phone;
	private Double solde;
	private String Role;
	private int nbvu;
	
	@ManyToMany(cascade = { CascadeType.ALL },fetch = FetchType.LAZY)
	@JoinTable(name = "client_spot", joinColumns = @JoinColumn(name = "Idclient"), inverseJoinColumns = @JoinColumn(name = "IdSpot"))
	private List<Spot> spotes = new ArrayList<>();
	/**************************************************/
	@OneToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "Idcompte")
	private Compte compte;

	public Client(int idclient, String username, String fullname, String password, String image, String email,
			String phone, Double solde, int nbvu, Compte compte) {
		super();
		Idclient = idclient;
		this.username = username;
		this.fullname = fullname;
		this.password = password;
		this.image = image;
		Email = email;
		this.phone = phone;
		this.solde = solde;
		this.nbvu = nbvu;
		this.compte = compte;
	}

	public Client() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getIdclient() {
		return Idclient;
	}

	public void setIdclient(int idclient) {
		Idclient = idclient;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public int getNbvu() {
		return nbvu;
	}

	public void setNbvu(int nbvu) {
		this.nbvu = nbvu;
	}

	@Override
	public String toString() {
		return "Client [Idclient=" + Idclient + ", username=" + username + ", fullname=" + fullname + ", password="
				+ password + ", image=" + image + ", Email=" + Email + ", phone=" + phone + ", solde=" + solde
				+ ", Role=" + Role + ", nbvu=" + nbvu + ", spotes=" + spotes + ", compte=" + compte + "]";
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}
  
	public List<Spot> getSpotes() {
		return spotes;
	}

	public void setSpotes(List<Spot> spotes) {
		this.spotes = spotes;
	}

}
