package tn.edu.esprit.hiwarWatani.client.delegate;

import java.util.List;

import tn.edu.esprit.hiwarWatani.client.locator.ServiceLocator;
import tn.edu.esprit.hiwarWatani.ejb.domain.Advisor;
import tn.edu.esprit.hiwarWatani.ejb.services.interfaces.RescueServicesRemote;

public class RescueServicesDelegate {
	private static final String jndiName = "ejb:/tn.edu.esprit.hiwarWatani.ejb/RescueServices!tn.edu.esprit.hiwarWatani.ejb.services.interfaces.RescueServicesRemote";

	private static RescueServicesRemote getProxy() {
		return (RescueServicesRemote) ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public static boolean doAddSomeThing(List<Object> allStuff) {
		return getProxy().createStuff(allStuff);
	}

	public static boolean doCreateAffectationMinisterToGovernment(
			int idMinister, int idGouvernment, String role) {
		return getProxy().createAffectationMinisterToGovernment(idMinister,
				idGouvernment, role);
	}

	public static boolean doDegage(int idGouvernment) {
		return getProxy().degage(idGouvernment);
	}

	public static Advisor doFindAdvisorById(int idAdvisor) {

		return getProxy().findAdvisorById(idAdvisor);
	}

	public static boolean doAssignAdvisorsToMinister(List<Advisor> advisors,
			int idMinister) {
		return getProxy().assignAdvisorsToMinister(advisors, idMinister);
	}

	public static List<Advisor> doFindAllAdvisersByGovernmentId(int idGovernment) {

		return getProxy().findAllAdvisersByGovernmentId(idGovernment);
	}

}
