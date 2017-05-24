package validator;

import model.Student;

public class StudentValidator {

	
	 public static int validateStudent(Student student) {
	        if(!student.getRegNumber().matches("[a-zA-Z]{4}[\\d]{4}")){
	            return 1;
	        }
	        if (!student.getName().matches("[a-zA-Z]+[\\s]?[a-zA-Z]+")) {
	            return 2;
	        }
	        if(student.getGroup() >= 1000 || student.getGroup() <= 0){
	            return 3;
	        }
	        return 0;
	    }
}
