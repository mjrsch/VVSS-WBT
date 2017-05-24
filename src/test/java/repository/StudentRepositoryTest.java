/**
 * 
 */
package repository;

import static org.junit.Assert.*;

import java.io.FileOutputStream;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Admin
 *
 */
public class StudentRepositoryTest {
	private static StudentRepository studRepo;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		studRepo= new StudentRepository("stud.txt");
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		FileOutputStream writer = new FileOutputStream("stud.txt");
		writer.write(("").getBytes());
		writer.close();
		
	}

	/*
	@Test
	public void testStudentRepository() {
		assertNotEquals(new StudentRepository("stud.txt"),studRepo);
	}
	*/
	/**
	 * Test method for {@link repository.StudentRepository#getFile()}.
	 */
	@Test
	public void testGetFile() {
		assertEquals("stud.txt",studRepo.getFile());
		assertNotEquals("std.txt",studRepo.getFile());
		assertNotEquals("123",studRepo.getFile());
		assertNotEquals("stud.pdf",studRepo.getFile());
		assertNotEquals("stud.xml",studRepo.getFile());
		assertNotEquals("stud@.txt",studRepo.getFile());
	}

	/**
	 * Test method for {@link repository.StudentRepository#setFile(java.lang.String)}.
	 */
	@Test
	public void testSetFile() {
		studRepo.setFile("std.txt");
		assertNotEquals("stud.txt",studRepo.getFile());
		assertEquals("std.txt",studRepo.getFile());
		studRepo.setFile("stud.pdf");
		assertNotEquals("stud.txt",studRepo.getFile());
		assertEquals("stud.pdf",studRepo.getFile());
		studRepo.setFile("stud.xml");
		assertNotEquals("stud.pdf",studRepo.getFile());
		assertNotEquals("stud.txt",studRepo.getFile());
		assertEquals("stud.xml",studRepo.getFile());
		
	}

	
}
