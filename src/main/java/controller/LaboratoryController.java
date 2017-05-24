package controller;

import java.io.IOException;
import java.text.ParseException;
import model.Laboratory;
import repository.LaboratoryRepository;
import validator.LaboratoryValidator;



public class LaboratoryController {

	private LaboratoryRepository laboratoryPersistence = new LaboratoryRepository(
            "labs.txt");
	
	public LaboratoryController( String laboratoryFile) {
    	this.laboratoryPersistence = new LaboratoryRepository(laboratoryFile);
    }
	
	public int saveLaboratory(Laboratory laboratory) {
		 int errorCodeFromValidator=LaboratoryValidator.validateLaboratory(laboratory);
	        if (errorCodeFromValidator==0) {
            this.laboratoryPersistence.saveLaboratory(laboratory);
	        }
       
        return errorCodeFromValidator;
    }
	
	
	//modificat nume variabila ca sa fie mai sugestiv, din student in studentName
	 public boolean addGrade(String studentName, String labNumber, float grade)
	            throws NumberFormatException, IOException, ParseException {
	        if (LaboratoryValidator.validateGrade(grade)) {
	            this.laboratoryPersistence.addGrade(studentName, labNumber, grade);
	            return true;
	        } else {
	            return false;
	        }
	    }
}
