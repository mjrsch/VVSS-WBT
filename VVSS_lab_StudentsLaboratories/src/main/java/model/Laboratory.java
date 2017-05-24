package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Laboratory {

    private int id;
    private Date date;
    private int problemNumber;
    private float grade;
    private String studentRegNumber;

    
    public Laboratory(){
    	this.id=15;
    	this.date=new Date();
    	this.problemNumber=1;
    	this.grade=10;
    	this.studentRegNumber="abab5132";
    	
    }
  
	
    public Laboratory(int id, String dateString, int problemNumber,
                      String studentRegNumber) throws ParseException {
        this.id = id; // problemNumber assigned to Number
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        this.date = format.parse(dateString);
        this.problemNumber = problemNumber; // number assigned to problem number
        this.studentRegNumber = studentRegNumber;
    }
    

    public Laboratory(int id, String date, int problemNumber, float grade,
                      String studentRegNumber) throws ParseException {
        this.id = id; // problemNumber assigned to Number
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        this.date = format.parse(date);
        this.problemNumber = problemNumber; // number assigned to problem number
        this.grade = grade;
        this.studentRegNumber = studentRegNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getProblemNumber() {
        return problemNumber;
    }

    public void setProblemNumber(int problemNumber) {
        this.problemNumber = problemNumber;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public String getStudentRegNumber() {
        return studentRegNumber;
    }

    public void setStudentRegNumber(String studentRegNumber) {
        this.studentRegNumber = studentRegNumber;
    }

    @SuppressWarnings("deprecation")
	@Override
    public String toString() {
        int month = date.getMonth() + 1;
        int year = date.getYear() + 1900;
        return id + " " + date.getDate() + "/" + month + "/" + year + " "
                + problemNumber + " " + grade + " " + studentRegNumber;
    }


}
