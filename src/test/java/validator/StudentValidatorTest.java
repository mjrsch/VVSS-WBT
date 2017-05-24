/**
 * 
 */
package validator;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Student;

/**
 * @author Admin
 *
 */
public class StudentValidatorTest {

		
		private Student student = new Student("abcd1234","Ana Avram", 2);
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Test method for {@link validator.StudentValidator#validateStudent(model.Student)}.
	 */
	@Test
	public void testValidateStudent() {
		
		assertEquals(StudentValidator.validateStudent(student),0);
		student.setRegNumber("123");
		assertEquals(StudentValidator.validateStudent(student),1);
		student.setRegNumber("abc1234");
		assertEquals(StudentValidator.validateStudent(student),1);
		student.setRegNumber("abcd123");
		assertEquals(StudentValidator.validateStudent(student),1);
		student.setRegNumber("abc");
		assertEquals(StudentValidator.validateStudent(student),1);
		student.setRegNumber("abc*1234");
		assertEquals(StudentValidator.validateStudent(student),1);
		student.setRegNumber("abcd1234");
		student.setName("12Abcd");
		assertEquals(StudentValidator.validateStudent(student),2);
		student.setName("12 Abcd");
		assertEquals(StudentValidator.validateStudent(student),2);
		student.setName("123");
		assertEquals(StudentValidator.validateStudent(student),2);
		student.setName("abcdEr!*");
		assertEquals(StudentValidator.validateStudent(student),2);
		student.setName("Alina S");
		assertEquals(StudentValidator.validateStudent(student),0);
		student.setName("alina s");
		assertEquals(StudentValidator.validateStudent(student),0);
		student.setGroup(-1);
		assertEquals(StudentValidator.validateStudent(student),3);
		student.setGroup(1001);
		assertEquals(StudentValidator.validateStudent(student),3);
		student.setGroup(0);
		assertEquals(StudentValidator.validateStudent(student),3);
		student.setGroup(1000);
		assertEquals(StudentValidator.validateStudent(student),3);
		student.setGroup(999);
		assertEquals(StudentValidator.validateStudent(student),0);
		
		
		
		
		
	}

}
