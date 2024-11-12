package afour;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class PlotTestStudent {
	private Plot plot1, plot5;

	@Before
	public void setUp() throws Exception {
		plot1 = new Plot(2, 2, 6, 6);
		plot5 = new Plot(3, 4, 4, 3);
	}

	@After
	public void tearDown() throws Exception {
		plot1 = plot5 = null;
	}

	@Test
	public void testOverlaps() {
		assertTrue(plot1.overlaps(plot5));
	}
	
	@Test
	public void testToString() {
		assertEquals("3,4,4,3",plot5.toString());	
	}

}