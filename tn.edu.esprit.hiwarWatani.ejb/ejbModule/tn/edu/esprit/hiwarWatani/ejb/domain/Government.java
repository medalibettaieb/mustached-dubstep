package tn.edu.esprit.hiwarWatani.ejb.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="T_Government")
public class Government implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 483269114504126711L;
	private int idGovernment;
	private String nameGovernment;

	private List<Affectation> affectations;

	public Government() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdGovernment() {
		return idGovernment;
	}

	public void setIdGovernment(int idGovernment) {
		this.idGovernment = idGovernment;
	}

	public String getNameGovernment() {
		return nameGovernment;
	}

	public void setNameGovernment(String nameGovernment) {
		this.nameGovernment = nameGovernment;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Government(String nameGovernment) {
		super();
		this.nameGovernment = nameGovernment;
	}

	@OneToMany(mappedBy = "government")
	public List<Affectation> getAffectations() {
		return affectations;
	}

	public void setAffectations(List<Affectation> affectations) {
		this.affectations = affectations;
	}

}
