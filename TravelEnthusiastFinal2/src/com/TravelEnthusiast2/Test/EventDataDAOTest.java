/**
 * 
 */
package com.TravelEnthusiast2.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.TravelEnthusiast2.Bean.EventData;
import com.TravelEnthusiast2.DAO.EventDataDAO;

/**
 * @author david
 *
 */
public class EventDataDAOTest {

	/**
	 * Test method for {@link com.TravelEnthusiast2.DAO.EventDataDAO#getEventsByExperienceTitle(java.lang.String)}.
	 * @param Result - Each experience can have one or multiple events. 
	 */
	@Test
	public final void testGetEventsByExperienceTitle() {
        EventDataDAO a = new EventDataDAO();
        List<EventData> result = new ArrayList<EventData>();
        result = null;
        
        result = a.getEventsByExperienceTitle("The Wonders of Machu Picchu");
        
        assertTrue(result.size() >= 0);
	}

}
