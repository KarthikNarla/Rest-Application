package com.infor.rest.controller;

import java.net.URI;

import com.infor.rest.dao.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.infor.rest.model.Student;
import com.infor.rest.model.Students;

import javax.websocket.server.PathParam;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.Response;

@RestController
@RequestMapping(path = "/details")
public class StudentController
{
    @Autowired
    private StudentDAO studentDao;

    @GetMapping(path="/status", produces = "application/json")
    public String getStatus() {
        return "OK";
    }
    
    @GetMapping(path="/students", produces = "application/json")
    public Students getStudents()
    {
        studentDao = new StudentDAO();
        return studentDao.getAllStudents();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/students")
    public void updateStudentList(@RequestBody Student student, @PathVariable("id") Integer rollNumber){
        studentDao.updateStudent(student, rollNumber);
    }



    @PostMapping(path= "/students", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addStudent(
                      //  @RequestHeader(name = "X-COM-PERSIST", required = true) String headerPersist,
                       // @RequestHeader(name = "X-COM-LOCATION", required = false, defaultValue = "ASIA") String headerLocation,
                        @RequestBody Student student)
                 throws Exception 
    {       
        //Generate resource id
        Integer rollNo = studentDao.getAllStudents().getStudentList().size() + 1;
        student.setRollNo(rollNo);
        
        //add resource
        System.out.println("Karthik");
        studentDao.addStudent(student);
        
        //Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(student.getRollNo())
                                    .toUri();
        
        //Send location in response
        return ResponseEntity.created(location).build();
    }
}
