package dblayer;
import modellayer.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class DBLocationTest {

	@Test
	public void testFindLocation() {
		DBLocation dbLoc = new DBLocation();
		Location loc = dbLoc.findLocation("9000");
		if(loc != null)
		{
			System.out.println("Location found");
		}
		else
		{
			fail("Not yet implemented");
		}
	}

}
