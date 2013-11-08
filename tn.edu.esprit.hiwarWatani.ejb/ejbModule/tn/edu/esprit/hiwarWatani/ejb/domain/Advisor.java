package tn.edu.esprit.hiwarWatani.ejb.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_Advisor")
public class Advisor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2830758738838902892L;
	private int idAdvisor;
	private String nameAdvisor;

	private Minister minister;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdAdvisor() {
		return idAdvisor;
	}

	public void setIdAdvisor(int idAdvisor) {
		this.idAdvisor = idAdvisor;
	}

	public String getNameAdvisor() {
		return nameAdvisor;
	}

	public void setNameAdvisor(String nameAdvisor) {
		this.nameAdvisor = nameAdvisor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Advisor() {
	}

	public Advisor(String nameAdvisor) {
		super();
		this.nameAdvisor = nameAdvisor;
	}

	@ManyToOne
	@JoinColumn(name="minister_FK")
	public Minister getMinister() {
		return minister;
	}

	public void setMinister(Minister minister) {
		this.minister = minister;
	}

	
	

}
