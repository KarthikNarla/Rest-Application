package com.infor.rest.dao;

import com.infor.rest.model.Student;
import com.infor.rest.model.Students;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentDAO
{
    private static Students listStudents = new Students();
    
    static 
    {
        listStudents.getStudentList().add(new Student(1, "Karthik", "Narla", "Computer Science", 01234556));
        listStudents.getStudentList().add(new Student(2, "Sai", "ram", "Computer Science", 487653));
        listStudents.getStudentList().add(new Student(3, "sai", "kumar", "Computer Science", 95626));
    }
    
    public Students getAllStudents()
    {
        return listStudents;
    }
    
    public void addStudent(Student student) {
        listStudents.getStudentList().add(student);
    }

    //TODO
    public void updateStudent(Student student, Integer rollNumber) throws Exception{
        int count =0;
        for(Student student1 : listStudents){
            if (student1.getRollNo().equals(rollNumber)){

            }
        }

        if(listStudents.getStudentList().contains(rollNumber)){

        }

    }
}
