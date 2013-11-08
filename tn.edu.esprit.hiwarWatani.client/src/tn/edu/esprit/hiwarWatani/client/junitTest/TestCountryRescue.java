package tn.edu.esprit.hiwarWatani.client.junitTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import tn.edu.esprit.hiwarWatani.client.delegate.RescueServicesDelegate;
import tn.edu.esprit.hiwarWatani.ejb.domain.Advisor;
import tn.edu.esprit.hiwarWatani.ejb.domain.Government;
import tn.edu.esprit.hiwarWatani.ejb.domain.Minister;

/**
 * 
 * @author labo1/daly
 * @category Exam Java EE6
 * @version 1.0
 * 
 * 
 */
public class TestCountryRescue {
	/**
	 * @ this method initialize the database with 3 minister 3 advisor and 2
	 * Government
	 */
	@Test
	public void testInitPoliticians() {
		Minister minister = new Minister("migalou");
		Minister minister2 = new Minister("wel 3mara");
		Minister minister3 = new Minister("7alle9");

		Advisor adviser = new Advisor("bahta");
		Advisor adviser2 = new Advisor("baya");
		Advisor adviser3 = new Advisor("samanta");

		Government government = new Government("troyka");
		Government government2 = new Government("in9adh");

		List<Object> allStuff = new ArrayList<Object>();
		allStuff.add(government);
		allStuff.add(government2);
		allStuff.add(minister);
		allStuff.add(minister2);
		allStuff.add(minister3);
		allStuff.add(adviser);
		allStuff.add(adviser2);
		allStuff.add(adviser3);

		Assert.assertTrue(RescueServicesDelegate.doAddSomeThing(allStuff));
	}

	/**
	 * this method assign ministers to government and one of them is prime
	 * minister
	 * 
	 * @param1 is the id of the minister
	 * @param2 is the id of the government
	 * @param3 is the role
	 * 
	 *         and do not forget to set the validity of the affectation to true
	 */
	@Test
	public void testCreateAffectationMinisterToGovernment() {
		Assert.assertTrue(RescueServicesDelegate
				.doCreateAffectationMinisterToGovernment(1, 1, "prime Minister"));
		Assert.assertTrue(RescueServicesDelegate
				.doCreateAffectationMinisterToGovernment(2, 1,
						"Minister of Finance"));
		Assert.assertTrue(RescueServicesDelegate
				.doCreateAffectationMinisterToGovernment(3, 1,
						"Minister of Religious Affairs"));
	}

	/**
	 * @param1 list of advisors
	 * @param2 id of the minister
	 * 
	 *         in this method you have only the right to merge on the minister
	 *         class
	 */
	@Test
	public void testAssignAdvisorsToMinister() {
		List<Advisor> advisors = new ArrayList<Advisor>();
		advisors.add(RescueServicesDelegate.doFindAdvisorById(1));
		advisors.add(RescueServicesDelegate.doFindAdvisorById(2));
		advisors.add(new Advisor("7oumani"));

		Assert.assertTrue(RescueServicesDelegate.doAssignAdvisorsToMinister(
				advisors, 1));
	}
	/**
	 * this method load all advisor of all the minister of one government
	 * 
	 * @param id of the government
	 */
	@Test
	public void testFindAllAdvisersByGovernmentId() {
		Assert.assertEquals(3, RescueServicesDelegate
				.doFindAllAdvisersByGovernmentId(1).size());
	}

	/**
	 * this method gives an end to the validity of the ministers of the
	 * government
	 * 
	 * @param id of the government to DEGAGE
	 */

	@Test
	public void TestDegage() {
		Assert.assertTrue(RescueServicesDelegate.doDegage(1));
	}

	

}
