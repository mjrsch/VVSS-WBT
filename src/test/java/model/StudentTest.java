package model;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class StudentTest {

	private static Student student;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		student= new Student("abcd1234","Ana Avram", 2);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}


	@Test
	public void testGetRegNumber() {
		assertEquals("abcd1234",student.getRegNumber());
		
	}

	@Test
	public void testSetRegNumber() {
		student.setRegNumber("wxyz6789");
		assertNotEquals("abcd1234",student.getRegNumber());
		assertEquals("wxyz6789",student.getRegNumber());
		
		
	}

	@Test
	public void testGetName() {
		assertEquals("Ana Avram",student.getName());
		
	}

	@Test
	public void testSetName() {
		student.setName("Lungu Augustin");
		assertNotEquals("Ana Avram",student.getName());
		assertEquals("Lungu Augustin",student.getName());
		
	}

	@Test
	public void testGetGroup() {
		assertEquals(2,student.getGroup());
	}

	@Test
	public void testSetGroup() {
		student.setGroup(3);
		assertNotEquals(2,student.getGroup());
		assertEquals(3,student.getGroup());
	}
}
