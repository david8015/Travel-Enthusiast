/**
 * 
 */
package com.TravelEnthusiast2.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.TravelEnthusiast2.Bean.*;
import com.TravelEnthusiast2.DAO.UserDAO;

/**
 * @author david
 *
 */
public class UserDAOTest {

	/**
	 * Test method for {@link com.TravelEnthusiast2.DAO.UserDAO#getUserByUserName(java.lang.String)}.
	 * @param result - Test method returned a user. Test User returned is the User searched for.  
	 */
	@Test
	public final void testGetUserByUserName() {
	 UserDAO a = new UserDAO();
	 User result = a.getUserByUserName("jhopkins");
	 
	 assertNotNull("should not be null", result);
	 assertEquals(result.getUserName(), "jhopkins");
	 
	}

	/**
	 * Test method for {@link com.TravelEnthusiast2.DAO.UserDAO#RegisterUser(com.TravelEnthusiast2.Bean.User)}.
	 * @param Result - Test method registered an user. Rows updated should equal 1.
	 */
	@Test
	public final void testRegisterUser() {
	  UserDAO a = new UserDAO();
	  User b = new User(1,"Ftest", "Ltest", "test@email.com", "utest", "abdc1235", "USA", 2);
	  int result = a.RegisterUser(b);
	  
	  assertEquals(result, 1);
	}

	/**
	 * Test method for {@link com.TravelEnthusiast2.DAO.UserDAO#getAllUsers()}.
	 * @param Result - is greater than 0 if method returned a list of users
	 */
	@Test
	public final void testGetAllUsers() {
		 UserDAO a = new UserDAO();
		 List<User> result = new ArrayList<User>();
		 result = a.getAllUsers();
		 
		 assertTrue(result.size()> 0);
	}

//	/**
//	 * Test method for {@link com.TravelEnthusiast2.DAO.UserDAO#deleteUser(java.lang.String)}.
//	 */
//	@Test
//	public final void testDeleteUser() {
//		UserDAO a = new UserDAO();
//		boolean result = false;
//		
//		result = a.deleteUser("jhopkins");
//		
//		assertTrue(result);
//			
//	}

	/**
	 * Test method for {@link com.TravelEnthusiast2.DAO.UserDAO#validateUser(java.lang.String, java.lang.String)}.
	 * @param Result - testing password match
	 */
	@Test
	public final void testValidateUser() {
		UserDAO a = new UserDAO();
		boolean result = false;
		
		String pass = "123abc";
	    String comPass = "123abc";
			    
		result = a.validateUser(pass, comPass);
		
		assertTrue(result);
	}

	/**
	 * Test method for {@link com.TravelEnthusiast2.DAO.UserDAO#editUserFName(java.lang.String, int)}.
	 * @param Result returns true if user's first name was updated
	 */
	@Test
	public final void testEditUserFName() {
		UserDAO a = new UserDAO();
		boolean result = false;
		
		result = a.editUserFName("test", 1);
		
		assertTrue(result);
	}
}
