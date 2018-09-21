/**
 * 
 */
package com.TravelEnthusiast2.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.TravelEnthusiast2.Bean.ExpData;
import com.TravelEnthusiast2.DAO.ExpDataDAO;

/**
 * @author david
 *
 */
public class ExpDataDAOTest {

	/**
	 * Test method for {@link com.TravelEnthusiast2.DAO.ExpDataDAO#getAllExperience()}.
	 */
	@Test
	public final void testGetAllExperience() {
		ExpDataDAO a = new ExpDataDAO();
		List<ExpData> result = new ArrayList<ExpData>();
		
		result = a.getAllExperience();
		
		assertTrue(result.size() > 0);
		
	}

	/**
	 * Test method for {@link com.TravelEnthusiast2.DAO.ExpDataDAO#getExperienceByTitle(java.lang.String)}.
	 */
	@Test
	public final void testGetExperienceByTitle() {
		ExpDataDAO a = new ExpDataDAO();
		List<ExpData> result = new ArrayList<ExpData>();
		
		result = a.getExperienceByTitle("Relaxation in Mexico");
		
		assertTrue(result.size() > 0);
	}

	/**
	 * Test method for {@link com.TravelEnthusiast2.DAO.ExpDataDAO#getExperienceByUser(java.lang.String)}.
	 */
	@Test
	public final void testGetExperienceByUser() {
		ExpDataDAO a = new ExpDataDAO();
		List<ExpData> result = new ArrayList<ExpData>();
		
		result = a.getExperienceByUser("jhopkins");
		
		assertTrue(result.size() > 0);
		
	}

}
