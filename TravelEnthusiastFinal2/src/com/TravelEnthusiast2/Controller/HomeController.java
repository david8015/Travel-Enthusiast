package com.TravelEnthusiast2.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.TravelEnthusiast2.Bean.*;
import com.TravelEnthusiast2.DAO.*;

/**
 * @author david
 *
 */
@Controller
@RequestMapping("/")
@SessionAttributes("userkey")
public class HomeController {
	// saving info to session
	@ModelAttribute("userkey")
	public User setUpUserForm() {
		return new User();

	}
	
	@ModelAttribute ("expDisplay")
	public ExpData SetUpExpDataForm(){
		return new ExpData();
	}
	
	@ModelAttribute ("eventDisplay")
	public EventData SetUpEventDataForm(){
		return new EventData();
	}

//	mapping to home page
	@RequestMapping("/")
	public ModelAndView welcome() {
		ModelAndView mav = new ModelAndView("welcome");
		return mav;
	}

	// saving info through the http request
	@RequestMapping(value = "/login_info", method = RequestMethod.POST)
	public ModelAndView login_info(@ModelAttribute("userkey") User u) {
		UserDAO y = new UserDAO();
		User z = y.getUserByUserName(u.getUserName());

		if (z == null) {
			ModelAndView mav = new ModelAndView("welcome");
			mav.addObject("incorrectInfo", "Incorrect user name or password");
			return mav;

		}

		if (y.validateUser(z.getPassword(), u.getPassword())) {
			if ((z.getUserType() == 0)) {
				ExperienceDAO expDAO = new ExperienceDAO();
				List<Experience> exp = new ArrayList<Experience>();
				exp = expDAO.getAllExperience();

				ExpDataDAO getList = new ExpDataDAO();
				List<ExpData> expList = new ArrayList<ExpData>();
				expList = getList.getAllExperience();

				ModelAndView mav = new ModelAndView("MainPage");
				mav.addObject("exp", exp);
				mav.addObject("expList", expList);
				return mav;
			} else {
				ModelAndView mav = new ModelAndView("AdminPage");
				return mav;
			}
		} else {
			ModelAndView mav = new ModelAndView("welcome");
			mav.addObject("incorrectInfo", "Incorrect user name or password");
			return mav;
		}
	}
	

	// SEACH LIST OF EXPERIENCES BY TITLE
	@RequestMapping(value = "/search_Exp_By_Title", method = RequestMethod.POST)
	public ModelAndView searchExpByTitle(@ModelAttribute("ExpData") ExpData x, @ModelAttribute ("userkey") User u) {
		ExpDataDAO y = new ExpDataDAO();
		List<ExpData> expTitleList = new ArrayList<ExpData>();
		expTitleList = y.getExperienceByTitle(x.getTitle());
		

			if(expTitleList.size() == 0 || expTitleList == null) {
				ModelAndView mav = new ModelAndView("MainPage");

				ExpDataDAO getList = new ExpDataDAO();
				List<ExpData> expList = new ArrayList<ExpData>();
				expList = getList.getAllExperience();

				mav.addObject("expList", expList);
				mav.addObject("noExpFound", "No experience found by that title.");

				return mav;
		
		}
		
		else {
			ModelAndView mav = new ModelAndView("MainPage");
			mav.addObject("expTitleList", expTitleList);
			return mav;
		}
	}
	
	
	//SEARCH LIST OF EXPERIENCES BY USERNAME
	@RequestMapping(value = "/search_Exp_By_User", method = RequestMethod.POST)
	public ModelAndView searchExpByUser(@ModelAttribute("ExpData") ExpData x, @ModelAttribute ("userkey") User u) {
		ExpDataDAO y = new ExpDataDAO();
		List<ExpData> expByUser = new ArrayList<ExpData>();
		expByUser = y.getExperienceByUser(x.getUsername());
		
		if(expByUser.size() == 0 || expByUser == null) {
			ModelAndView mav = new ModelAndView("MainPage");

			ExpDataDAO getList = new ExpDataDAO();
			List<ExpData> expList = new ArrayList<ExpData>();
			expList = getList.getAllExperience();

			mav.addObject("expList", expList);
			mav.addObject("noExpFound", "No experience found by that User.");

			return mav;
		}
		
		else {
			ModelAndView mav = new ModelAndView("MainPage");
			mav.addObject("expByUser", expByUser);
			return mav;
		}
	}
	

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(@ModelAttribute("userkey") User u) {
		ModelAndView mav = new ModelAndView("MainPage");

		ExpDataDAO getList = new ExpDataDAO();
		List<ExpData> expList = new ArrayList<ExpData>();
		expList = getList.getAllExperience();

		mav.addObject("expList", expList);

		return mav;
	}	
	
	//mapping for event pages / comments
	@RequestMapping(value = "/eventpage", method = RequestMethod.GET)
	public ModelAndView getComments(@ModelAttribute("ExpData") ExpData x, 
			@ModelAttribute("EventDisplay") EventData y, @ModelAttribute ("userkey") User u, HttpServletRequest request) {
		
		EventDataDAO a = new EventDataDAO();
		List<EventData> eventByExpTitle = new ArrayList<EventData>();
		eventByExpTitle = a.getEventsByExperienceTitle(x.getTitle());
	
		//Save event ID and title to session. Will be used later to save the comments for each event.
		int eventID = 0;
		String eventTitle = "";
		
		for (EventData s: eventByExpTitle) {
			eventID = s.getEventId();
			eventTitle = s.getEventTitle();
		}
		
		HttpSession se = request.getSession();
		se.setAttribute("eventID", eventID);
		se.setAttribute("eventTitle", eventTitle);
		
		//if experiences do no have any events - return initial list of experiences with message
		if (eventByExpTitle.size() == 0 || eventByExpTitle == null) {
			ModelAndView mav = new ModelAndView("MainPage");

			ExpDataDAO getList = new ExpDataDAO();
			List<ExpData> expList = new ArrayList<ExpData>();
			expList = getList.getAllExperience();

			mav.addObject("expList", expList);
			mav.addObject("noEventsFound", "No events found for selected experience.");

			return mav;
			
		}
		
		//if one event found. Map to event page and load comments based on the experience title
		else if (eventByExpTitle.size() == 1) {
			CommentsDAO c = new CommentsDAO();
			List<Comments> commentsByExpTitle = new ArrayList<Comments>();
			commentsByExpTitle = c.getCommentsByExpTitle(x.getTitle());
			
			ModelAndView mav = new ModelAndView("event");
			mav.addObject("eventByExpTitle", eventByExpTitle);
			mav.addObject("commentsByExpTitle", commentsByExpTitle);
			return mav;
			
		}
		
		//if multiple events found. Map to multipleEvents page
		else {
			ModelAndView mav = new ModelAndView("multipleEvents");
			mav.addObject("eventByExpTitle", eventByExpTitle);
			return mav;
		}
	}
	

//	ADD COMMENTS TO EVENT
	@RequestMapping(value = "/addComment", method = RequestMethod.POST)
	public ModelAndView addComment(@RequestParam("commentsDescription") String comment,
			@ModelAttribute ("userkey") User u, HttpServletRequest request) {
		int added =0;
		String eventTitle = "";
		
//		GET ALL INFO OF CURRENT USER. TO GET USER ID.
		UserDAO userDAO = new UserDAO();
		User user = new User();
		user = userDAO.getUserByUserName(u.getUserName());
		

//		grab event ID from session attribute (saved when mapped to event page from MainPage)
		int eventID = 0;
		
		HttpSession se = request.getSession();
		eventID = (int) se.getAttribute("eventID");
	
//      PASS INFO TO THE CommentsDAO TO ADD TO Comments TABLE.
		CommentsDAO cdao = new CommentsDAO();
		added = cdao.addComment(comment, eventID, user.getUserID());
	
//      IF COMMENT WAS ADDED RETURN TO Event PAGE WITH NEW COMMENT LISTED 
//		(NAMED LISTS eventByExpTitle & commentsByExpTitle FOR DISPLAYING ON Event PAGE)
		if (added > 0) {
			eventTitle = (String) se.getAttribute("eventTitle");
			CommentsDAO d = new CommentsDAO();
			List<Comments> commentsByEventTitle = new ArrayList<Comments>();
			commentsByEventTitle = d.getCommentsByEventTitle(eventTitle);

			
			EventDataDAO edDAO = new EventDataDAO();
			List<EventData> ed = new ArrayList<EventData>();
			ed = edDAO.getEventDataByEventID(eventID);
			
			ModelAndView mav = new ModelAndView("event");
			mav.addObject("eventByExpTitle", ed);
			mav.addObject("commentsByExpTitle", commentsByEventTitle);
			
			return mav;
		}
//		OTHERWISE PRINT ERROR MESSAGE
		else
			return null;
	}
		
		
    /**
     * 
     * @return registration page
     */
	@RequestMapping(value = "/registerPage", method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView mav = new ModelAndView("register");
		return mav;
	}

	@RequestMapping(value = "/register_info", method = RequestMethod.POST)
	public ModelAndView register_info(@ModelAttribute("userkey") User u) {
		UserDAO user = new UserDAO();
		if (user.getUserByUserName(u.getUserName()) == null) {
			int registered = user.RegisterUser(u);

			if (registered > 0) {
				ModelAndView mav = new ModelAndView("welcome");
				mav.addObject("success", "You are all set. Sign in.");
				return mav;
			} else {
				ModelAndView mav = new ModelAndView("register");
				mav.addObject("couldNotRegister", "Registration error. Try again");
				return mav;
			}

		} else {
			ModelAndView mav = new ModelAndView("register");
			mav.addObject("userNameError", "user name already exists.");
			return mav;
		}
	}

	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public ModelAndView mypage(@ModelAttribute("userkey") User u) {
//      get user
		UserDAO userDAO = new UserDAO();
		User user = new User();
		user = userDAO.getUserByUserName(u.getUserName());

//      get Experience list by user
		ExperienceDAO exp = new ExperienceDAO();
		List<Experience> userExpList = new ArrayList<Experience>();
		userExpList = exp.getExperienceByUser(u.getUserName());
		
		ModelAndView mav = new ModelAndView("mypage");
		mav.addObject("userInfo", user);
		mav.addObject("userExpList", userExpList);
		return mav;
	}
	
	@RequestMapping(value = "/editInfo", method = RequestMethod.GET)
	public ModelAndView editInfoPage(@ModelAttribute("userkey") User u) {
		UserDAO userDAO = new UserDAO();
		User user = new User();
		user = userDAO.getUserByUserName(u.getUserName());
		
		ModelAndView mav = new ModelAndView("editInfoPage");
		mav.addObject("userInfo", user);
		return mav;
		
	}
	
//	Edit user first name. Return user with changed info.
	@RequestMapping(value = "/editFName", method = RequestMethod.POST)
	public ModelAndView editFName(@RequestParam("fname") String firstName, @ModelAttribute("userkey") User u) {
		UserDAO a = new UserDAO();
		boolean b = false;
		
		UserDAO userDAO1 = new UserDAO();
		User c = new User();
		c = userDAO1.getUserByUserName(u.getUserName());
	
		b = a.editUserFName(firstName, c.getUserID());
		
		
		if (b) {
			UserDAO userDAO = new UserDAO();
			User user = new User();
			user = userDAO.getUserByUserName(u.getUserName());
			
			ModelAndView mav = new ModelAndView("editInfoPage");
			mav.addObject("userInfo", user);
			return mav;
		}
		return null;
	}
	
	@RequestMapping(value = "/editLName", method = RequestMethod.POST)
	public ModelAndView editLName(@RequestParam("LName") String lastName, @ModelAttribute("userkey") User u) {
		UserDAO a = new UserDAO();
		boolean b = false;
		
		UserDAO userDAO1 = new UserDAO();
		User c = new User();
		c = userDAO1.getUserByUserName(u.getUserName());
	
		b = a.editUserLName(lastName, c.getUserID());
		
		
		if (b) {
			UserDAO userDAO = new UserDAO();
			User user = new User();
			user = userDAO.getUserByUserName(u.getUserName());
			
			ModelAndView mav = new ModelAndView("editInfoPage");
			mav.addObject("userInfo", user);
			return mav;
		}
		return null;
	}
	
	
	@RequestMapping(value = "/editEmail", method = RequestMethod.POST)
	public ModelAndView editEmail(@RequestParam("Email") String Email, @ModelAttribute("userkey") User u) {
		UserDAO a = new UserDAO();
		boolean b = false;
		
		UserDAO userDAO1 = new UserDAO();
		User c = new User();
		c = userDAO1.getUserByUserName(u.getUserName());
	
		b = a.editUserEmail(Email, c.getUserID());
		
		
		if (b) {
			UserDAO userDAO = new UserDAO();
			User user = new User();
			user = userDAO.getUserByUserName(u.getUserName());
			
			ModelAndView mav = new ModelAndView("editInfoPage");
			mav.addObject("userInfo", user);
			return mav;
		}
		return null;
	}
	
	@RequestMapping(value = "/editPassword", method = RequestMethod.POST)
	public ModelAndView editPassword(@RequestParam("Password") String Password, @ModelAttribute("userkey") User u) {
		UserDAO a = new UserDAO();
		boolean b = false;
		
		UserDAO userDAO1 = new UserDAO();
		User c = new User();
		c = userDAO1.getUserByUserName(u.getUserName());
	
		b = a.editUserPassword(Password, c.getUserID());
		
		
		if (b) {
			UserDAO userDAO = new UserDAO();
			User user = new User();
			user = userDAO.getUserByUserName(u.getUserName());
			
			ModelAndView mav = new ModelAndView("editInfoPage");
			mav.addObject("userInfo", user);
			return mav;
		}
		return new ModelAndView ("welcome");
		
	}
	
	@RequestMapping(value = "/editCountry", method = RequestMethod.POST)
	public ModelAndView editCountry(@RequestParam("Country") String Country, @ModelAttribute("userkey") User u) {
		UserDAO a = new UserDAO();
		boolean b = false;
		
		UserDAO userDAO1 = new UserDAO();
		User c = new User();
		c = userDAO1.getUserByUserName(u.getUserName());
	
		b = a.editUserCountry(Country, c.getUserID());
		
		
		if (b) {
			UserDAO userDAO = new UserDAO();
			User user = new User();
			user = userDAO.getUserByUserName(u.getUserName());
			
			ModelAndView mav = new ModelAndView("editInfoPage");
			mav.addObject("userInfo", user);
			return mav;
		}
		return null;
	}
	
	
	@RequestMapping(value = "/addExperience", method = RequestMethod.GET)
	public ModelAndView addExperience(@ModelAttribute("userkey") User u) {
		ModelAndView mav = new ModelAndView("addExperience");
		return mav;
	}
	
	
	@RequestMapping(value = "/inputExperience", method = RequestMethod.POST)
	public ModelAndView inputExperience(@ModelAttribute("userkey") User u, @ModelAttribute("exp") Experience e, 
			@ModelAttribute("pic") Picture p) {
		UserDAO a = new UserDAO();
		User user = new User();
		user = a.getUserByUserName(u.getUserName());
	
		ExperienceDAO expDAO = new ExperienceDAO();
		int b = expDAO.addExperience(e, user.getUserID(), p);
		
		ExperienceDAO exp = new ExperienceDAO();
		List<Experience> userExpList = new ArrayList<Experience>();
		userExpList = exp.getExperienceByUser(u.getUserName());
		
		ModelAndView mav = new ModelAndView("mypage");
		mav.addObject("userInfo", user);
		mav.addObject("userExpList", userExpList);
		return mav;
	}
	
	@RequestMapping(value = "/addEventPage", method = RequestMethod.GET)
	public ModelAndView addEvent(@RequestParam("title") String title, @RequestParam("experienceID") int experienceID, 
			@ModelAttribute("userkey") User u, HttpServletRequest request) {
		//add the experience ID to the session level
		HttpSession se = request.getSession();
		se.setAttribute("experienceID", experienceID);
		
		//get the title of selected experience and pass it to new JSP page for referencing and printing
		ModelAndView mav = new ModelAndView("addEvent");
		mav.addObject("title", title);
		return mav;
	}
	
	@RequestMapping(value = "/inputEvent", method = RequestMethod.POST)
	public ModelAndView inputEvent(@ModelAttribute("userkey") User u, @ModelAttribute ("Event")Event e, 
			@ModelAttribute ("picture") Picture p, HttpServletRequest request) {
		
		//get the experience ID from session attribute
		HttpSession se = request.getSession();
		int expID = (int) se.getAttribute("experienceID");
	
		//add event ( and picture of event) to the database
		EventDataDAO a = new EventDataDAO();
	    a.addEventData(e, expID, p);
		
	    ModelAndView mav = new ModelAndView("MainPage");
		return mav;
		
	}
		
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public ModelAndView contactPage(@ModelAttribute("userkey") User u) {
		ModelAndView mav = new ModelAndView("contact");
		return mav;
	}

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public ModelAndView about(@ModelAttribute("userkey") User u) {
		ModelAndView mav = new ModelAndView("aboutUsPage");
		return mav;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(@ModelAttribute("userkey") User u, HttpServletRequest request) {
		HttpSession se = request.getSession();
		se.invalidate();
		ModelAndView mav = new ModelAndView("welcome");
		return mav;
	}

}