/**
 * 
 */
package com.TravelEnthusiast2.Test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.TravelEnthusiast2.Bean.Experience;
import com.TravelEnthusiast2.Bean.Picture;
import com.TravelEnthusiast2.DAO.ExperienceDAO;

/**
 * @author david
 *
 */
public class ExperienceDAOTest {

	/**
	 * Test method for {@link com.TravelEnthusiast2.DAO.ExperienceDAO#getAllExperience()}.
	 * @param Result - gets all experience from database
	 * @Result size of result list greater than 1
	 */
	@Test
	public final void testGetAllExperience() {
		ExperienceDAO a = new ExperienceDAO();
		List<Experience> result = new ArrayList<Experience>();
		
		result = a.getAllExperience();
		
		assertTrue(result.size() > 0);
		
	}

	/**
	 * Test method for {@link com.TravelEnthusiast2.DAO.ExperienceDAO#getExperienceByUser(java.lang.String)}.
	 * @param Result - gets all experience by user from database
	 * @Result size of list of experience greater than 1
	 */
	@Test
	public final void testGetExperienceByUser() {
		ExperienceDAO a = new ExperienceDAO();
		List<Experience> result = new ArrayList<Experience>();
		
		result = a.getExperienceByUser("jhopkins");
		
		assertTrue(result.size() > 0);
		
	}

	/**
	 * Test method for {@link com.TravelEnthusiast2.DAO.ExperienceDAO#addExperience(com.TravelEnthusiast2.Bean.Experience, int)}.
	 * @throws SQLException 
	 * @param Result - adds an experience by user from database
	 * @Result a list of generated primary key(s)
	 */
	@Test
	public final void testAddExperience() throws SQLException {
		ExperienceDAO a = new ExperienceDAO();
		Experience x = new Experience();
		Picture p = new Picture();
		int result = 0;
		
		x.setDescription("test description");
		x.setExperiencedate("2000-01-01");
		x.setExperiencetype("beach - relaxation");
		x.setTitle("testing title 1");
		
		p.setPictureTitle("test");
		p.setLandmark(true);
		p.setPhoto_date("2018-05-18");
		p.setPicture_of("buildings");
		p.setImage("https://res.cloudinary.com/david8015/image/upload/v1537531845/NYC-Skyline.jpg");
		
		result = a.addExperience(x, 1, p);
		assertTrue(result > 0);
	}

}
