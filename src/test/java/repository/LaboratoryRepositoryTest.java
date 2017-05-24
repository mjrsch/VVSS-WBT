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
public class LaboratoryRepositoryTest {
		private static LaboratoryRepository laboRepo;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		laboRepo= new LaboratoryRepository("laboratories.txt");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		FileOutputStream writer = new FileOutputStream("laboratories.txt");
		writer.write(("").getBytes());
		writer.close();
	}

	/*
	@Test
	public void testLaboratoryRepository() {
		assertNotEquals(new LaboratoryRepository("laboratories.txt"),laboRepo);
	}
	*/
	/**
	 * Test method for {@link repository.LaboratoryRepository#getFile()}.
	 */
	@Test
	public void testGetFile() {
		assertEquals("laboratories.txt",laboRepo.getFile());
		assertNotEquals("labo.txt",laboRepo.getFile());
		assertNotEquals("123",laboRepo.getFile());
		assertNotEquals("labo.pdf",laboRepo.getFile());
		assertNotEquals("labo.xml",laboRepo.getFile());
		assertNotEquals("labo@.txt",laboRepo.getFile());
	}

	/**
	 * Test method for {@link repository.LaboratoryRepository#setFile(java.lang.String)}.
	 */
	@Test
	public void testSetFile() {
		laboRepo.setFile("labo.txt");
		assertNotEquals("laboratories.txt",laboRepo.getFile());
		assertEquals("labo.txt",laboRepo.getFile());
		laboRepo.setFile("labo.pdf");
		assertNotEquals("labo.txt",laboRepo.getFile());
		assertEquals("labo.pdf",laboRepo.getFile());
		laboRepo.setFile("labo.xml");
		assertNotEquals("labo.pdf",laboRepo.getFile());
		assertNotEquals("labo.txt",laboRepo.getFile());
		assertEquals("labo.xml",laboRepo.getFile());
	}



}
