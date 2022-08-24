import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import com.svend.planes.Choice;
import com.svend.planes.controller.FlightScheduleController;
import com.svend.planes.domain.FlightSchedule;
import com.svend.planes.domain.Planes;


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

	@Test
	public void testCreate() {
		FlightSchedule testFlight = new FlightSchedule("testCompany", 1, "testDepartureTime");
		FlightSchedule result = cq.create(testFlight);
		assertEquals("FlightSchedule [id=0, company=testCompany, stand=1, takeoffTimeEst=testDepartureTime]", result.toString());
	}
	
	@Test
	public void testRead() {
		String result = cq.read();
		assertEquals("SELECT * FROM flight_schedule;", result);
	}
	
	@Test
	public void testUpdate( ) {
		FlightSchedule testFlight = new FlightSchedule(1,null, 1, "testColourForUpdate");
		assertEquals("UPDATE flight_schedule SET take_off_time = '" + "testColourForUpdate" + "' WHERE id = " + 1 + ";", cq.update(testFlight));
		
	}
	@Test
	public void testDelete( ) {
		
		FlightSchedule testFlight = new FlightSchedule(100, "Company Delete", 32, "NoColourDeleteImminent"); 
		cq.create(testFlight);// create a new object, so we can create a new record that is going to be deleted
		
		assertEquals("DELETE FROM flight_schedule WHERE id=" + testFlight.getId() + ";", cq.delete(testFlight));
		
	}
	
	@Test
	public void testReadByID( ) {
		
		FlightSchedule testFlight = new FlightSchedule(1); 
		assertEquals("FlightSchedule [id=1, company=BA, stand=20, takeoffTimeEst=testColourForUpdate]", cq.readByID(testFlight).toString());
		
	}

	@Test
	public void testReadByName( ) {
		
		FlightSchedule testFlight = new FlightSchedule("SAS"); 
		assertEquals("FlightSchedule [id=18, company=SAS, stand=3, takeoffTimeEst=4pm]", cq.readByName(testFlight).toString());
		
	}
	
	@Test
	public void testConnOpen( ) {
		
		assertEquals(true,cq.closeConn());
		
	}

	@Test
	public void testTostring() {
		FlightSchedule f = new FlightSchedule(0, "testcompany", 2, "testTime");
		String out = "FlightSchedule [id=0, company=testcompany, stand=2, takeoffTimeEst=testTime]";
		assertEquals(out, f.toString());
		System.out.println("Test 2");
	}
	
	
//	@Test // attempting to test the scanner input, doesnt seem to close so this is not working atm
//	public void shouldTakeUserInput() {
//	    Choice choice= new Choice();
//
//	    String input = "create";
//	    InputStream in = new ByteArrayInputStream(input.getBytes());
//	    System.setIn(in);
//
//	    assertEquals("create", choice.getInput());
//	}
//	
}

