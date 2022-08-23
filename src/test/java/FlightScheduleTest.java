import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.svend.planes.controller.FlightScheduleController;
import com.svend.planes.domain.FlightSchedule;


public class FlightScheduleTest {
	FlightScheduleController cq = new FlightScheduleController();
	@BeforeClass
	public static void setup() {
	    System.out.println("Before class");
	}

	@Test
	public void testGettersAndSetters() {
		FlightSchedule testPlane = new FlightSchedule(1000,"testCompany", 1, "testTime");
		cq.create(testPlane);
		assertEquals(1000, testPlane.getId());
		assertEquals("testCompany", testPlane.getCompany());
		assertEquals(1, testPlane.getStand());
		assertEquals("testTime", testPlane.getTakeoffTimeEst());
	}

}
