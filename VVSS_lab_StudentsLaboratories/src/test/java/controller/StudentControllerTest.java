/**
 * 
 */
package controller;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Student;

/**
 * @author Admin
 *
 */
public class StudentControllerTest {

		private static StudentController studController;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		studController= new StudentController("stud.txt");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/*
	@Test
	public void testStudentController() {
		assertNotEquals(new StudentController("stud.txt"),studController);
	}
	*/

	/**
	 * Test method for {@link controller.StudentController#saveStudent(model.Student)}.
	 */
	@Test
	public void testSaveStudent() {
		Student stud=new Student("abcd1194","Ana Darie", 5);
		assertEquals(studController.saveStudent(stud),0);
		assertNotEquals(studController.saveStudent(stud),1);
		assertNotEquals(studController.saveStudent(stud),2);
		//assertNotEquals(studController.saveStudent(stud),3);
		stud.setRegNumber("abc1234");
		assertEquals(studController.saveStudent(stud),1);
		assertNotEquals(studController.saveStudent(stud),0);
		assertNotEquals(studController.saveStudent(stud),2);
		assertNotEquals(studController.saveStudent(stud),3);
		stud.setRegNumber("abcd124");
		assertEquals(studController.saveStudent(stud),1);
		assertNotEquals(studController.saveStudent(stud),0);
		assertNotEquals(studController.saveStudent(stud),2);
		assertNotEquals(studController.saveStudent(stud),3);
		stud.setRegNumber("ab!a1234");
		assertEquals(studController.saveStudent(stud),1);
		assertNotEquals(studController.saveStudent(stud),0);
		assertNotEquals(studController.saveStudent(stud),2);
		assertNotEquals(studController.saveStudent(stud),3);
		stud.setRegNumber("abcd1@34");
		assertEquals(studController.saveStudent(stud),1);
		assertNotEquals(studController.saveStudent(stud),0);
		assertNotEquals(studController.saveStudent(stud),2);
		assertNotEquals(studController.saveStudent(stud),3);
		stud.setRegNumber("1234");
		assertEquals(studController.saveStudent(stud),1);
		assertNotEquals(studController.saveStudent(stud),0);
		assertNotEquals(studController.saveStudent(stud),2);
		assertNotEquals(studController.saveStudent(stud),3);
		stud.setRegNumber("abcd");
		assertEquals(studController.saveStudent(stud),1);
		assertNotEquals(studController.saveStudent(stud),0);
		assertNotEquals(studController.saveStudent(stud),2);
		assertNotEquals(studController.saveStudent(stud),3);
		stud.setRegNumber("abcd1234");
		stud.setGroup(-1);
		assertEquals(studController.saveStudent(stud),3);
		assertNotEquals(studController.saveStudent(stud),0);
		assertNotEquals(studController.saveStudent(stud),2);
		assertNotEquals(studController.saveStudent(stud),1);
		stud.setGroup(0);
		assertEquals(studController.saveStudent(stud),3);
		assertNotEquals(studController.saveStudent(stud),0);
		assertNotEquals(studController.saveStudent(stud),2);
		assertNotEquals(studController.saveStudent(stud),1);
		stud.setGroup(1000);
		assertEquals(studController.saveStudent(stud),3);
		assertNotEquals(studController.saveStudent(stud),0);
		assertNotEquals(studController.saveStudent(stud),2);
		assertNotEquals(studController.saveStudent(stud),1);
		stud.setGroup(1004);
		assertEquals(studController.saveStudent(stud),3);
		assertNotEquals(studController.saveStudent(stud),0);
		assertNotEquals(studController.saveStudent(stud),2);
		assertNotEquals(studController.saveStudent(stud),1);
	}
}
