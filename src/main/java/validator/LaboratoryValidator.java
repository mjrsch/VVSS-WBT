package validator;

import java.util.Date;

import model.Laboratory;

public class LaboratoryValidator {

	public static int validateLaboratory(Laboratory laboratory) {
        if(laboratory.getId() < 1) {
            return 1;
        }
        if(laboratory.getProblemNumber() > 10 || laboratory.getProblemNumber() < 1) {
            return 2;
        }
        Date date = new Date();
        // if(date.after(laboratory.getDate())==false)
        if(date.before(laboratory.getDate())==true) {
            return 3;
        }
        return 0;
    }
	
	public static boolean validateGrade(float grade) {
        if(grade >= 1 && grade <=10) {
            return true;
        }
        return false;
    }
}
