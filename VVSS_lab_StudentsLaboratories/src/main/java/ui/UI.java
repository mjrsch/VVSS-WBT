package ui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.List;
import controller.LaboratoryController;
import controller.StudentController;
import model.Laboratory;
import model.Student;


public class UI {

	
		private LaboratoryController laboController;
		private StudentController studController;

	    public UI(){
	    }

	    public void run() throws IOException{
	        System.out.println("Starting");

	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        this.laboController= new LaboratoryController("labs.txt");
	        this.studController= new StudentController("students.txt");

	        while(true){
	            System.out.println(" 1) Add student \n "
	            		+ "2) Add Laboratory \n "
	            		+ "3) Add grade \n "
	            		+ "4) Get passing students \n"
	            		+ "0) Exit the application \n");

	            String line = br.readLine();

	            if(line.equals("1")){
	                String registrationNumber, name;
	                int group;
	                System.out.print("Registration number: ");
	                registrationNumber = br.readLine();
	                System.out.print("Name: ");
	                name = br.readLine();
	                try {
	                    System.out.print("Group number: ");
	                    String groupString = br.readLine();
	                    group = Integer.parseInt(groupString);
	                } catch (NumberFormatException e) {
	                    System.out.println("Invalid group - not a number");
	                    continue;
	                }

	                Student student = new Student(registrationNumber, name, group);
	                int statusCode = studController.saveStudent(student);
	                System.out.println(statusCode);
	                if (statusCode==1)
	                	System.out.println("Invalid registration number! Please try again! "
	                			+ "The number must have 4 letters followed by 4 digits.");
	                	
	                else if (statusCode==2)
	                	System.out.println("Invalid name! Please try again!"
	                			+ "The name must contain only letters.");
	                	
	                else if (statusCode==3)
	                	System.out.println("Invalid group number! Please try again!"
	                			+ "The group number must be between [0,1000].");
	                	
	                else
	                	if (statusCode!=0)
	                	System.out.println("Unknown error!");
	                	
	                
	                
	            }

	            if(line.equals("2")){
	                int id, problemNumber;
	                String date, studentRegNumber;

	                try {
	                    System.out.println("Lab id: ");
	                    String labNumberString = br.readLine();
	                    System.out.println("Problem number: ");
	                    String labProblemNumberString = br.readLine();
	                    id = Integer.parseInt(labNumberString);
	                    problemNumber = Integer.parseInt(labProblemNumberString);
	                } catch (NumberFormatException e) {
	                    System.out.println("Invalid input");
	                    continue;
	                }

	                System.out.println("Date (dd/mm/yyy)");
	                date = br.readLine();
	                System.out.println("Student reg number:");
	                studentRegNumber = br.readLine();
	                Laboratory lab;
	                try {
	                    lab = new Laboratory(id, date, problemNumber, studentRegNumber);
	                } catch (ParseException e) {
	                    System.out.println("Invalid input");
	                    continue;
	                }
	               
	                int validationCode = laboController.saveLaboratory(lab);
	                if (validationCode==1)
	                	System.out.println("Invalid id for laboratory! Please try again!"
	                			+ "The id of the laboratory must be greater or equal to 1!");
	                else if (validationCode==2)
	                	System.out.println("Invalid problem number! Please try again!"
	                			+ "The problem number must be between [1,10].");
	                else if (validationCode==3)
	                	System.out.println("The date exceeds the first one!");
	                else 
	                	if (validationCode!=0)
	                		System.out.println("Unknown error!");
	                
	            }

	            if(line.equals("3")){
	                String registrationNumber, labNumber;
	                float grade;
	                System.out.println("Reg number: ");
	                registrationNumber = br.readLine();
	                System.out.println("Lab number: ");
	                labNumber = br.readLine();
	                try {
	                    System.out.println("Grade: ");
	                    String gradeString = br.readLine();
	                    grade = Float.parseFloat(gradeString);
	                } catch (NumberFormatException e) {
	                    System.out.println("Invalid grade!");
	                    continue;
	                }
	                try {
	                    Boolean success = laboController.addGrade(registrationNumber, labNumber, grade);
	                    if (!success) {
	                        System.out.println("Invalid grade! Please try again!"
	                    		+ "It must be between [1,10].");
	                    }
	                } catch (NumberFormatException|IOException|ParseException e) {
	                    System.out.println("Cannot save grade!");
	                }

	            }

	            if(line.equals("4")){
	                try {
	                    List<Student> passingStudents = studController.passedStudents();
	                    System.out.println("Passing students: ");
	                    for ( Student student : passingStudents) {
	                        System.out.println("\t - " + student.toString());
	                    }
	                } catch (ParseException e) {
	                    System.out.println("Error! Could not get passing students.");
	                }
	            }
	            if (line.equals("0")){
	            	
	            	System.out.println("You have chosen to exit the application");
	            		break;
	            }
	        }
	    }
	} 
