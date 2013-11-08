package tn.edu.esprit.hiwarWatani.ejb.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.edu.esprit.hiwarWatani.ejb.domain.Advisor;
import tn.edu.esprit.hiwarWatani.ejb.domain.Affectation;
import tn.edu.esprit.hiwarWatani.ejb.domain.Government;
import tn.edu.esprit.hiwarWatani.ejb.domain.Minister;
import tn.edu.esprit.hiwarWatani.ejb.services.interfaces.RescueServicesRemote;

@Stateless
public class RescueServices implements RescueServicesRemote {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public boolean createStuff(List<Object> allStuff) {
		boolean b = false;
		try {
			for (Object object : allStuff) {
				entityManager.persist(object);
			}
			b = true;

		} catch (Exception e) {
			System.err.println("insert error");
		}
		return b;
	}

	@Override
	public boolean createAffectationMinisterToGovernment(int idMinister,
			int idGouvernment, String role) {
		boolean b = false;
		try {
			Minister ministerFound = entityManager.find(Minister.class,
					idMinister);
			Government governmentFound = entityManager.find(Government.class,
					idGouvernment);
			Affectation affectation = new Affectation(role, ministerFound,
					governmentFound);
			entityManager.persist(affectation);
			b = true;

		} catch (Exception e) {
			System.err.println("update error");
		}
		return b;
	}

	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	public boolean degage(int idGouvernment) {
		boolean b = false;
		try {
			Government government = entityManager.find(Government.class,
					idGouvernment);
			String jpql = "select a from Affectation a where a.government =:gov ";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("gov", government);
			List<Affectation> affectationsOfThisGovernment = query
					.getResultList();
			for (Affectation aff : affectationsOfThisGovernment) {
				aff.setValidity(false);
			}
			b = true;

		} catch (Exception e) {
			System.err.println("es9at error");
		}
		return b;
	}

	@Override
	public Advisor findAdvisorById(int idAdvisor) {
		return entityManager.find(Advisor.class, idAdvisor);
	}

	@Override
	public boolean assignAdvisorsToMinister(List<Advisor> advisorsToAdd,
			int idMinister) {
		boolean b = false;
		try {
			Minister ministerFounf = entityManager.find(Minister.class,
					idMinister);
			ministerFounf.assignAdvisorsToThisMinister(advisorsToAdd);
			entityManager.merge(ministerFounf);
			b = true;

		} catch (Exception e) {
			System.err.println("assign error");
		}
		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Advisor> findAllAdvisersByGovernmentId(int idGovernment) {
		Government government = entityManager.find(Government.class,
				idGovernment);
		String jpql = "select distinct a from Advisor a join a.minister m join m.affectations aff where aff.government =:gov and aff.validity=:v";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("gov", government).setParameter("v",true);
		List<Advisor> advisorsFound = query.getResultList();
		return advisorsFound;
	}
}
