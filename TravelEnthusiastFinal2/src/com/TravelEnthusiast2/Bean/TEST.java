package com.TravelEnthusiast2.Bean;

import java.util.ArrayList;
import java.util.List;

import com.TravelEnthusiast2.DAO.CommentsDAO;
import com.TravelEnthusiast2.DAO.EventDataDAO;
import com.TravelEnthusiast2.DAO.ExpDataDAO;
import com.TravelEnthusiast2.DAO.ExperienceDAO;
import com.TravelEnthusiast2.DAO.UserDAO;

public class TEST {

	public static void main(String[] args) {
//		ExpDataDAO a = new ExpDataDAO();
//		List<ExpData> b = new ArrayList<ExpData>(); 
//		b = a.getAllExperience();
//		
//		for (ExpData s: b) {
//			System.out.println(s.getImage());
//			System.out.println(s.getUsername());
//			System.out.println(s.getPosted_date());
//			System.out.println(s.getDescription());
//			System.out.println(s.getTitle());
//			System.out.println(s.getExperienceDate());
//			
//		}
//		
//		System.out.println("By title: \n");
//		
//		List<ExpData> c = new ArrayList<ExpData>();
//		c= a.getExperienceByTitle("Relaxation in Mexico");
//		
//		for (ExpData s: c) {
//			System.out.println(s.getImage());
//			System.out.println(s.getUsername());
//			System.out.println(s.getPosted_date());
//			System.out.println(s.getDescription());
//			System.out.println(s.getTitle());
//			System.out.println(s.getExperienceDate());
//		}
//		
//		System.out.println("By user name: \n");
		
//		List<ExpData> d = new ArrayList<ExpData>();
//		d= a.getExperienceByUser("jhopkins");
//		
//		for (ExpData s: d) {
//			System.out.println(s.getImage());
//			System.out.println(s.getUsername());
//			System.out.println(s.getPosted_date());
//			System.out.println(s.getDescription());
//			System.out.println(s.getTitle());
//			System.out.println(s.getExperienceDate());
//		}
		
//		System.out.println("events by Experience title: \n");
//		EventDataDAO e =  new EventDataDAO();
//		List<EventData> f = new ArrayList<EventData>();
//		f = e.getEventsByExperienceTitle("The Wonders of Machu Picchu");
//		
//		for (EventData s: f) {
//			System.out.println(s.getUserName());
//			System.out.println(s.getEventTitle());
//			System.out.println(s.getEventImage());
//			System.out.println(s.getEventDate());
//			System.out.println(s.getEventPostedDate());
//			System.out.println(s.getEventDescription());
//			
//		}	
		
//		System.out.println("\n comments by event title: \n");
//		CommentsDAO g =  new CommentsDAO();
//		List<Comments> h = new ArrayList<Comments>();
//		h = g.getCommentsByEventTitle("Relaxing day in Mexico");
//		
//		for (Comments s: h) {
//			System.out.println(s.getUserName());
//			System.out.println(s.getPostedDate());
//			System.out.println(s.getDescription());
//			
//		}
//		
//		System.out.println("\n comments by exp title: \n");
//		CommentsDAO i =  new CommentsDAO();
//		List<Comments> j = new ArrayList<Comments>();
//		j = i.getCommentsByExpTitle("Relaxation in Mexico");
//		
//		for (Comments s: j) {
//			System.out.println(s.getUserName());
//			System.out.println(s.getPostedDate());
//			System.out.println(s.getDescription());
//		}
//		
//		System.out.println("\n exp by username: \n");
//		ExperienceDAO k =  new ExperienceDAO();
//		List<Experience> l = new ArrayList<Experience>();
//		l = k.getExperienceByUser("jhopkins");
//		
//		for (Experience s: l) {
//			System.out.println(s.getId());
//			System.out.println(s.getTitle());
//			System.out.println(s.getExperiencedate());
//			System.out.println(s.getExperiencetype());
//			System.out.println(s.getPosteddate());
//			System.out.println(s.getDescription());
//			System.out.println(s.getUserID());
//		}
		
		UserDAO a = new UserDAO();
		boolean b = false;
		
		b = a.editUserFName("John", 1);
		
		System.out.println(b);
		
	}
}
