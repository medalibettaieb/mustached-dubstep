package tn.edu.esprit.hiwarWatani.ejb.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "T_Minister")
public class Minister implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7985017936615506981L;

	private int idMinister;
	private String nameMinister;

	private List<Affectation> affectations;
	private List<Advisor> advisors;

	public Minister() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdMinister() {
		return idMinister;
	}

	public void setIdMinister(int idMinister) {
		this.idMinister = idMinister;
	}

	public String getNameMinister() {
		return nameMinister;
	}

	public void setNameMinister(String nameMinister) {
		this.nameMinister = nameMinister;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Minister(String nameMinister) {
		super();
		this.nameMinister = nameMinister;
	}

	@OneToMany(mappedBy = "minister")
	public List<Affectation> getAffectations() {
		return affectations;
	}

	public void setAffectations(List<Affectation> affectations) {
		this.affectations = affectations;
	}

	@OneToMany(mappedBy = "minister", cascade = CascadeType.MERGE)
	public List<Advisor> getAdvisors() {
		return advisors;
	}

	public void setAdvisors(List<Advisor> advisors) {
		this.advisors = advisors;
	}

	public void assignAdvisorsToThisMinister(List<Advisor> advisorsToAdd) {
		this.advisors = advisorsToAdd;
		for (Advisor a : advisorsToAdd) {
			a.setMinister(this);
		}
	}

}
