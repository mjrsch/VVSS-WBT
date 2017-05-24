package validator;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import model.Laboratory;

public class LaboratoryValidatorTest {

	
	private Laboratory lab=new Laboratory();
	       
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	
	
	@Test
	public void testValidateLaboratory() {
	lab.setProblemNumber(-1);
	assertEquals(LaboratoryValidator.validateLaboratory(lab),2);
	lab.setProblemNumber(0);
	assertEquals(LaboratoryValidator.validateLaboratory(lab),2);
	lab.setProblemNumber(11);
	assertEquals(LaboratoryValidator.validateLaboratory(lab),2);
	lab.setProblemNumber(1);	
	lab.setId(-1);
	assertEquals(LaboratoryValidator.validateLaboratory(lab),1);
	lab.setId(0);
	assertEquals(LaboratoryValidator.validateLaboratory(lab),1);
	lab.setId(10);

	}

	@Test
	public void testValidateGrade() {
		assertTrue(LaboratoryValidator.validateGrade(9));
		assertTrue(LaboratoryValidator.validateGrade(2));
		assertTrue(LaboratoryValidator.validateGrade(1));
		assertTrue(LaboratoryValidator.validateGrade(10));
		assertFalse(LaboratoryValidator.validateGrade(0));
		assertFalse(LaboratoryValidator.validateGrade(-1));
		assertFalse(LaboratoryValidator.validateGrade(-11));
		assertTrue(LaboratoryValidator.validateGrade(8));
		assertTrue(LaboratoryValidator.validateGrade(7));
		assertTrue(LaboratoryValidator.validateGrade(6));
		assertTrue(LaboratoryValidator.validateGrade(5));
		assertTrue(LaboratoryValidator.validateGrade(4));
		assertTrue(LaboratoryValidator.validateGrade(3));
		
		
	}

}
