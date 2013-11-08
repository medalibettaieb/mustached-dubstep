package tn.edu.esprit.hiwarWatani.ejb.services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.esprit.hiwarWatani.ejb.domain.Advisor;

@Remote
public interface RescueServicesRemote {

	boolean createStuff(List<Object> allStuff);

	boolean createAffectationMinisterToGovernment(int idMinister,
			int idGouvernment, String role);

	boolean degage(int idGouvernment);

	Advisor findAdvisorById(int idAdvisor);

	boolean assignAdvisorsToMinister(List<Advisor> advisors, int idMinister);

	List<Advisor> findAllAdvisersByGovernmentId(int idGovernment);

}
