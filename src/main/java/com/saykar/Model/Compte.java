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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Compte")
public class Compte implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Idcompte;
	private double monatnt;
	@OneToMany(targetEntity = Retrait.class, mappedBy = "compte", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Retrait> Retrait;

	public Compte(int idcompte, double monatnt) {
		super();
		Idcompte = idcompte;
		this.monatnt = monatnt;
		Retrait = new ArrayList<>();
	}

	public Compte() {

	}

	public int getIdcompte() {
		return Idcompte;
	}

	public void setIdcompte(int idcompte) {
		Idcompte = idcompte;
	}

	public double getMonatnt() {
		return monatnt;
	}

	public void setMonatnt(double monatnt) {
		this.monatnt = monatnt;
	}
	
	
	public List<Retrait> getRetrait() {
		return Retrait;
	}

	public void setRetrait(List<Retrait> retrait) {
		Retrait = retrait;
	}

	@Override
	public String toString() {
		return "Compte [Idcompte=" + Idcompte + ", monatnt=" + monatnt + ", Retrait=" + Retrait + "]";
	}

}
