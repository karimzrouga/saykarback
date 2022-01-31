package com.saykar.Model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Retrait")
public class Retrait {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Idretrait;
	private Date date;
	private Double Rmontant;
	@ManyToOne
	@JoinColumn(name = "Idcompte")
	private Compte compte;

	public Retrait(int idretrait, Date date, Double rmontant) {
		super();
		Idretrait = idretrait;
		this.date = date;
		Rmontant = rmontant;
	}

	public Retrait() {

	}

	public int getIdretrait() {
		return Idretrait;
	}

	public void setIdretrait(int idretrait) {
		Idretrait = idretrait;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getRmontant() {
		return Rmontant;
	}

	public void setRmontant(Double rmontant) {
		Rmontant = rmontant;
	}

	@Override
	public String toString() {
		return "Retrait [Idretrait=" + Idretrait + ", date=" + date + ", Rmontant=" + Rmontant + "]";
	}

	@JsonBackReference
	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

}
