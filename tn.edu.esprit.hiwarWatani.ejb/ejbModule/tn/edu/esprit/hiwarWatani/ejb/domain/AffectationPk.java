package tn.edu.esprit.hiwarWatani.ejb.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class AffectationPk implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -151264922382490701L;
	private int idMin;
	private int idGov;
	private Date dateOfAffectation;

	public int getIdMin() {
		return idMin;
	}

	public void setIdMin(int idMin) {
		this.idMin = idMin;
	}

	public int getIdGov() {
		return idGov;
	}

	public void setIdGov(int idGov) {
		this.idGov = idGov;
	}

	public Date getDateOfAffectation() {
		return dateOfAffectation;
	}

	public void setDateOfAffectation(Date dateOfAffectation) {
		this.dateOfAffectation = dateOfAffectation;
	}

	public AffectationPk() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((dateOfAffectation == null) ? 0 : dateOfAffectation
						.hashCode());
		result = prime * result + idGov;
		result = prime * result + idMin;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AffectationPk other = (AffectationPk) obj;
		if (dateOfAffectation == null) {
			if (other.dateOfAffectation != null)
				return false;
		} else if (!dateOfAffectation.equals(other.dateOfAffectation))
			return false;
		if (idGov != other.idGov)
			return false;
		if (idMin != other.idMin)
			return false;
		return true;
	}

	public AffectationPk(int idMin, int idGov, Date dateOfAffectation) {
		super();
		this.idMin = idMin;
		this.idGov = idGov;
		this.dateOfAffectation = dateOfAffectation;
	}

}
