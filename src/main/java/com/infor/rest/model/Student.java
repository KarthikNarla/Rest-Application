package com.infor.rest.model;

public class Student {

    public Student() {

    }

    public Student(Integer rollNo, String firstName, String lastName, String course, Integer mobileNumber) {
        super();
        this.rollNo = rollNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.mobileNumber = mobileNumber;
    }
 
    private Integer rollNo;
    private String firstName;
    private String lastName;
    private String course;
    private Integer mobileNumber;

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Integer getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Integer mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "Student [id=" + rollNo + ", firstName=" + firstName + ", lastName=" + lastName + ", mobileNumber=" + mobileNumber + ", course=" + course +"]";
    }
}
