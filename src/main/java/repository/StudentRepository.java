package repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Student;

public class StudentRepository {
	
	private String file;

    public StudentRepository(String file) {
        this.file = file;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public void saveStudent(Student student) {
        try {
            BufferedWriter writer;
            writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(student.toString() + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public List<Student> getStudentsList() throws NumberFormatException,
    IOException {
    	BufferedReader reader = new BufferedReader(new FileReader(file));
    	List<Student> allStudentsList = new ArrayList<Student>();

    	String line = null;

    	while ((line = reader.readLine()) != null) {
	    String[] temp = line.split(" ");
	    Student student = new Student(temp[0], temp[1] + temp[2], Integer.valueOf(temp[3]));
	    allStudentsList.add(student);
    	}
    	reader.close();
    	return allStudentsList;
    }
    
    
}
