package tn.edu.esprit.hiwarWatani.ejb.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Affectation
 * 
 */
@Entity
@Table(name="T_Affectation")
public class Affectation implements Serializable {

	private AffectationPk affectationPk;
	private String role;
	private boolean validity;
	private static final long serialVersionUID = 1L;

	private Minister minister;
	private Government government;

	public Affectation() {
		super();
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@EmbeddedId
	public AffectationPk getAffectationPk() {
		return affectationPk;
	}

	public void setAffectationPk(AffectationPk affectationPk) {
		this.affectationPk = affectationPk;
	}

	@ManyToOne
	@JoinColumn(name = "idMin", referencedColumnName = "idMinister", insertable = false, updatable = false)
	public Minister getMinister() {
		return minister;
	}

	public void setMinister(Minister minister) {
		this.minister = minister;
	}

	@ManyToOne
	@JoinColumn(name = "idGov", referencedColumnName = "idGovernment", insertable = false, updatable = false)
	public Government getGovernment() {
		return government;
	}

	public void setGovernment(Government government) {
		this.government = government;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Affectation(String role, Minister minister, Government government) {
		super();
		this.validity = true;
		this.role = role;
		this.minister = minister;
		this.government = government;
		this.affectationPk = new AffectationPk(minister.getIdMinister(),
				government.getIdGovernment(), new Date());
	}

	public boolean isValidity() {
		return validity;
	}

	public void setValidity(boolean validity) {
		this.validity = validity;
	}

}
