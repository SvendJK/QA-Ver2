import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.svend.planes.controller.PlanesController;
import com.svend.planes.domain.Planes;


public class PlaneTest {
PlanesController cq = new PlanesController();


@BeforeClass
public static void setup() {
    System.out.println("Before class");
}

@Test
public void testGettersAndSetters() {
	Planes testPlane = new Planes(1000,"testCompany", 1, "testColour");
	cq.create(testPlane);
	assertEquals(1000, testPlane.getId());
	assertEquals("testCompany", testPlane.getCompany());
	assertEquals(1, testPlane.getStand());
	assertEquals("testColour", testPlane.getColour());
}

@Test
public void testCreate() {
	Planes testPlane = new Planes("testCompany", 1, "testColour");
	Planes result = cq.create(testPlane);
	assertEquals("Planes [id="+testPlane.getId() +", company=testCompany, stand=1, colour=testColour]", result.toString());
}

@Test
public void testRead() {
	String result = cq.read();
	assertEquals("SELECT * FROM planes;", result);
}

@Test
public void testUpdate( ) {
	Planes testPlane = new Planes(1,null, 1, "testColourForUpdate");
	assertEquals("UPDATE planes SET colour = '" + "testColourForUpdate" + "' WHERE id = " + 1 + ";", cq.update(testPlane));
	
}

@Test
public void testDelete( ) {
	
	Planes testPlane = new Planes(100, "Company Delete", 32, "NoColourDeleteImminent"); 
	cq.create(testPlane);// create a new object, so we can create a new record that is going to be deleted
	
	System.out.println("HERE " + testPlane.getId()); 
	assertEquals("DELETE FROM planes WHERE id=" + testPlane.getId() + ";", cq.delete(testPlane));
	
}

@Test
public void testReadByID( ) {
	
	Planes testPlane = new Planes(1); 
	assertEquals("Planes [id=1, company=BA, stand=0, colour=testColourForUpdate]", cq.readByID(testPlane).toString());
	
}

@Test
public void testReadByName( ) {
	
	Planes testPlane = new Planes("Jet2"); 
	assertEquals("Planes [id=5, company=jet2, stand=23, colour=red]", cq.readByName(testPlane).toString());
	
}
@Test
public void testConnOpen( ) {
	
	assertEquals(true,cq.closeConn());
	
}

@Test
public void testTostring() {
	Planes p = new Planes(0, "testcompany", 2, "testcolour");
	String out = "Planes [id=0, company=testcompany, stand=2, colour=testcolour]";
	assertEquals(out, p.toString());
	System.out.println("Test 2");
}
}




