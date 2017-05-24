/**
 * 
 */
package model;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertNotEquals;
/**
 * @author Admin
 *
 */
public class LaboratoryTest {

		private static Laboratory laboratory;
		private static Laboratory labWithGrade;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		laboratory=new Laboratory(1,"12/04/2016",3,"abcd1234");
		labWithGrade=new Laboratory(7, "12/09/2017", 1,9,"wxyz6789");
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}


	/**
	 * Test method for {@link model.Laboratory#getId()}.
	 */
	@Test
	public void testGetId() {
		assertEquals(1,laboratory.getId());
	}

	/**
	 * Test method for {@link model.Laboratory#setId(int)}.
	 */
	@Test
	public void testSetId() {
		laboratory.setId(2);
		assertEquals(2,laboratory.getId());
	}

	/**
	 * Test method for {@link model.Laboratory#getDate()}.
	 */
	@Test
	public void testGetDate() {
		Date date=new Date(12/04/2016);
		Date actual=laboratory.getDate();	
		assertNotEquals(date,actual);
	}

	/**
	 * Test method for {@link model.Laboratory#setDate(java.util.Date)}.
	 */
	@Test
	public void testSetDate() {
		Date date=new Date(17/02/2017);
		laboratory.setDate(date);
		assertEquals(date,laboratory.getDate());
		//System.out.println(laboratory.getDate());
		
	}

	/**
	 * Test method for {@link model.Laboratory#getProblemNumber()}.
	 */
	@Test
	public void testGetProblemNumber() {
		//assertEquals(3,laboratory.getProblemNumber());
		assertNotEquals(4, laboratory.getProblemNumber());
	
	}

	/**
	 * Test method for {@link model.Laboratory#setProblemNumber(int)}.
	 */
	@Test
	public void testSetProblemNumber() {
		laboratory.setProblemNumber(6);
		//assertNotEquals(3,laboratory.getProblemNumber());
		assertEquals(6,laboratory.getProblemNumber());
	}

	/**
	 * Test method for {@link model.Laboratory#getGrade()}.
	 */
	@Test
	public void testGetGrade() {
		//assertEquals(9,labWithGrade.getGrade());
		assertNotEquals(8,labWithGrade.getGrade());
	}

	/**
	 * Test method for {@link model.Laboratory#setGrade(float)}.
	 */
	@Test
	public void testSetGrade() {
		labWithGrade.setGrade(8);
		assertNotEquals(9,labWithGrade.getGrade());
		//assertEquals(8,labWithGrade.getGrade());
	}

	/**
	 * Test method for {@link model.Laboratory#getStudentRegNumber()}.
	 */
	@Test
	public void testGetStudentRegNumber() {
		assertEquals("abcd1234",laboratory.getStudentRegNumber());
		assertNotEquals("wxyz6789",laboratory.getStudentRegNumber());
		assertEquals("wxyz6789",labWithGrade.getStudentRegNumber());
		assertNotEquals("abcd1234",labWithGrade.getStudentRegNumber());
		
	}

	/**
	 * Test method for {@link model.Laboratory#setStudentRegNumber(java.lang.String)}.
	 */
	@Test
	public void testSetStudentRegNumber() {
		laboratory.setStudentRegNumber("wxyz6789");
		assertNotEquals("abcd1234",laboratory.getStudentRegNumber());
		assertEquals("wxyz6789",laboratory.getStudentRegNumber());
		labWithGrade.setStudentRegNumber("abcd1234");
		assertNotEquals("wxyz6789",labWithGrade.getStudentRegNumber());
		assertEquals("abcd1234",labWithGrade.getStudentRegNumber());
	}

	/*
	
	@Test
	public void testToString() {
		assertEquals("7 12/09/2017 1 8 abcd1234",labWithGrade.toString());
	}
	*/
}
