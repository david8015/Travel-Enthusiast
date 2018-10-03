package com.TravelEnthusiast2.DAOI;

import java.util.List;

import com.TravelEnthusiast2.Bean.User;

public interface UserDAOI {
	
	User getUserByUserName(String userName);
	
	void RegisterUser(User u);
	
    List<User> getAllUsers();
    
    Boolean deleteUser(String userName);
}
