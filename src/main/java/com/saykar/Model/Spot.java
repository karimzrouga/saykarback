package com.saykar.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Spot")
public class Spot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IdSpot")
	private int IdSpot;
	private String titre;
	private Double nbvues;
	private String montant;
	private Double nbvuessouhaite;
	private String Video;
	private LocalDate date;
	private String nameEntreprise;
	private String image;
	private int likes;
	/******************************************************************************/

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "spotes")
	@JsonIgnore
	private List<Client> clients = new ArrayList<>();
	/******************************************************************************/
	@ManyToOne
	@JoinColumn(name = "IdEntreprise", nullable = false)
	@JsonIgnore
	private Entreprise entreprise;

	/******************************************************************************/

	public Spot(int idSpot, String titre, Double nbvues, String montant, Double nbvuessouhait, String video,
			LocalDate date, List<Client> clients, Entreprise entreprise, int likes) {
		super();
		IdSpot = idSpot;
		this.titre = titre;
		this.nbvues = nbvues;
		this.montant = montant;
		this.nbvuessouhaite = nbvuessouhait;
		Video = video;
		this.date = date;
		this.clients = clients;
		this.entreprise = entreprise;
		this.likes = likes;

	}

	public Spot() {

	}

	public int getIdSpot() {
		return IdSpot;
	}

	public void setIdSpot(int idSpot) {
		IdSpot = idSpot;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Double getNbvues() {
		return nbvues;
	}

	public void setNbvues(Double nbvues) {
		this.nbvues = nbvues;
	}

	public String getMontant() {
		return montant;
	}

	public void setMontant(String montant) {
		this.montant = montant;
	}

	public String getVideo() {
		return Video;
	}

	public void setVideo(String video) {
		Video = video;
	}

	public List<Client> getClients() {

		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate localDate) {
		this.date = localDate;
	}

	public Double getNbvuessouhaite() {
		return nbvuessouhaite;
	}

	public void setNbvuessouhaite(Double nbvuessouhaite) {
		this.nbvuessouhaite = nbvuessouhaite;
	}

	public String getNameEntreprise() {
		return nameEntreprise;
	}

	public void setNameEntreprise(String nameEntreprise) {
		this.nameEntreprise = nameEntreprise;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	@Override
	public String toString() {
		return "Spot [IdSpot=" + IdSpot + ", titre=" + titre + ", nbvues=" + nbvues + ", montant=" + montant
				+ ", nbvuessouhaite=" + nbvuessouhaite + ", Video=" + Video + ", date=" + date + ", nameEntreprise="
				+ nameEntreprise + ", image=" + image + ", likes=" + likes + ", clients=" + clients + ", entreprise="
				+ entreprise + "]";
	}

}
