/**
 * 
 */
package com.TravelEnthusiast2.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.TravelEnthusiast2.Bean.Picture;
import com.TravelEnthusiast2.DAO.PictureDAO;

/**
 * @author david
 *
 */
public class PicturesDAOTest {

	/**
	 * Test method for {@link com.TravelEnthusiast2.DAO.PicturesDAO#getAllPictures()}.
	 * @param Result - test size of picture list is greater than 0
	 */
	@Test
	public final void testGetAllPictures() {
		PictureDAO a = new PictureDAO();
		List<Picture> result = new ArrayList<Picture>();
		
		result = a.getAllPictures();
		
		assertTrue(result.size() > 0);
		
	}
	
	/**
	 * Test method for {@link com.TravelEnthusiast2.DAO.PicturesDAO#getAllPictures()}.
	 * @param Result - test size of picture list is greater than 0
	 */
	@Test
	public final void AddPicture(Picture u, int b) {
		PictureDAO a = new PictureDAO();
		List<Picture> result = new ArrayList<Picture>();
		
		result = a.getAllPictures();
		
		assertTrue(result.size() > 0);
		
	}

}
