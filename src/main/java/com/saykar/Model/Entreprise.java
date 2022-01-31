package com.saykar.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Entreprise")
public class Entreprise {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int IdEntreprise;
	private String companyname;
	private String adresse;
	private String password;
	private String image;
	private String Email;
	private String phone;
	private String facebook;
	private String instagram;
	private String twitter;
	private String username;
	private String role;
	private  Double solde;
	/*************************************************************************/
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "fllow", joinColumns = @JoinColumn(name = "IdEntreprise"), inverseJoinColumns = @JoinColumn(name = "Idclient"))
	private List<Client> clients = new ArrayList<>();
	/*******************************************/
	@OneToMany(mappedBy = "entreprise")
	private List<Spot> Listspot = new ArrayList<>();

	public Entreprise(int idEntreprise, String companyname, String adresse, String password, String image, String email,
			String phone, String facebook, String username, String instagram, String twitter, List<Client> clients,
			List<Spot> listspot,Double solde) {
		super();
		IdEntreprise = idEntreprise;
		this.companyname = companyname;
		this.adresse = adresse;
		this.password = password;
		this.image = image;
		Email = email;
		this.phone = phone;
		this.facebook = facebook;
		this.instagram = instagram;
		this.twitter = twitter;
		this.clients = clients;
		Listspot = listspot;
		this.username = username;
		this.role="company";
		this.solde=solde;
	}

	public Entreprise() {
	}

	public int getIdEntreprise() {
		return IdEntreprise;
	}

	public void setIdEntreprise(int idEntreprise) {
		IdEntreprise = idEntreprise;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public List<Spot> getListspot() {
		return Listspot;
	}

	public void setListspot(List<Spot> listspot) {
		Listspot = listspot;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Entreprise [IdEntreprise=" + IdEntreprise + ", companyname=" + companyname + ", adresse=" + adresse
				+ ", password=" + password + ", image=" + image + ", Email=" + Email + ", phone=" + phone
				+ ", facebook=" + facebook + ", instagram=" + instagram + ", twitter=" + twitter + ", username="
				+ username + ", clients=" + clients + ", Listspot=" + Listspot + "]";
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

}