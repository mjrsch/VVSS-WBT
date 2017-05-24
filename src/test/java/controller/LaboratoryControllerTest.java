/**
 * 
 */
package controller;

import static org.junit.Assert.*;

import java.io.FileOutputStream;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Laboratory;

/**
 * @author Admin
 *
 */
public class LaboratoryControllerTest {
	private static LaboratoryController laboController;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		laboController= new LaboratoryController("laboratories.txt");
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
	public void testLaboratoryController() {
		assertNotEquals(new LaboratoryController("laboratories.txt"),laboController);
	}
*/
	
	/**
	 * Test method for {@link controller.LaboratoryController#saveLaboratory(model.Laboratory)}.
	 */
	@Test
	public void testSaveLaboratory() {
		Laboratory lab=new Laboratory();
		assertEquals(laboController.saveLaboratory(lab),0);
		assertNotEquals(laboController.saveLaboratory(lab),1);
		assertNotEquals(laboController.saveLaboratory(lab),2);
		assertNotEquals(laboController.saveLaboratory(lab),3);
		lab.setId(-1);
		assertEquals(laboController.saveLaboratory(lab),1);
		assertNotEquals(laboController.saveLaboratory(lab),0);
		assertNotEquals(laboController.saveLaboratory(lab),2);
		assertNotEquals(laboController.saveLaboratory(lab),3);
		lab.setId(0);
		assertEquals(laboController.saveLaboratory(lab),1);
		assertNotEquals(laboController.saveLaboratory(lab),0);
		assertNotEquals(laboController.saveLaboratory(lab),2);
		assertNotEquals(laboController.saveLaboratory(lab),3);
		lab.setId(3);
		lab.setProblemNumber(0);
		assertEquals(laboController.saveLaboratory(lab),2);
		assertNotEquals(laboController.saveLaboratory(lab),0);
		assertNotEquals(laboController.saveLaboratory(lab),1);
		assertNotEquals(laboController.saveLaboratory(lab),3);
		lab.setProblemNumber(123);
		assertEquals(laboController.saveLaboratory(lab),2);
		assertNotEquals(laboController.saveLaboratory(lab),0);
		assertNotEquals(laboController.saveLaboratory(lab),1);
		assertNotEquals(laboController.saveLaboratory(lab),3);
		lab.setProblemNumber(11);
		assertEquals(laboController.saveLaboratory(lab),2);
		assertNotEquals(laboController.saveLaboratory(lab),0);
		assertNotEquals(laboController.saveLaboratory(lab),1);
		assertNotEquals(laboController.saveLaboratory(lab),3);
		lab.setProblemNumber(-1);
		assertEquals(laboController.saveLaboratory(lab),2);
		assertNotEquals(laboController.saveLaboratory(lab),0);
		assertNotEquals(laboController.saveLaboratory(lab),1);
		assertNotEquals(laboController.saveLaboratory(lab),3);
		
		
		
	}

	

}
