import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.svend.planes.CRUDqueries;
import com.svend.planes.Planes;


public class CRUDqueriesTest {
CRUDqueries cq = new CRUDqueries();


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
	Planes testPlane = new Planes(1000,"testCompany", 1, "testColour");
	String result = cq.create(testPlane);
	assertEquals("INSERT INTO planes(company, stand, colour) VALUES('testCompany',1,'testColour');", result);
}



@Test
public void testReadById( ) {
	Planes testPlane = new Planes(1234,"testCompany", 1, "testColour");
	
	
}


}




