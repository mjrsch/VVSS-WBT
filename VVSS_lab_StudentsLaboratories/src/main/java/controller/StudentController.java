package controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import model.Laboratory;
import model.Student;
import repository.LaboratoryRepository;
import repository.StudentRepository;
import validator.StudentValidator;


public class StudentController {
	
	private StudentRepository studentPersistence = new StudentRepository(
            "students.txt");
	private LaboratoryRepository laboRepo;
	
	public StudentController( String studentFile) {
    	this.studentPersistence = new StudentRepository(studentFile);
    }
	
	 public int saveStudent(Student student) {
		
		 
		 int errorCodeFromValidator=StudentValidator.validateStudent(student);
	        if (errorCodeFromValidator==0) {
	            this.studentPersistence.saveStudent(student);
	        }
          return errorCodeFromValidator;
	       
	    }
	 
	 
	 public List<Student> passedStudents() throws NumberFormatException,
     IOException, ParseException {
	 Map<String, List<Laboratory>> laboratoryMap = laboRepo.getLaboratoryMap();
	 List<Student> studentsList = studentPersistence.getStudentsList();
	
	 List<Student> passedStudents = new ArrayList<>();
	 Entry<String, List<Laboratory>> entry;
	
	 Set<Entry<String, List<Laboratory>>> entrySet = laboratoryMap.entrySet();
	 Iterator<Entry<String, List<Laboratory>>> iterator = entrySet.iterator();
	
	 while (iterator.hasNext()) {
	     entry = iterator.next();
	     float midGrade = entry.getValue().get(0).getGrade();
	     for (Laboratory laboratory : entry.getValue()) {
	         midGrade = (midGrade + laboratory.getGrade()) / 2;
	     }
	     System.out.println(midGrade);
	     if (midGrade >= 5) {
	         Student student = new Student();
	         student.setRegNumber(entry.getKey());
	         int indexOf = studentsList.indexOf(student);
	         passedStudents.add(studentsList.get(indexOf));
	     }
	 }
	
	 return passedStudents;
}
}
