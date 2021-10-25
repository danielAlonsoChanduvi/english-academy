package com.dcode.englishacademy.controller;

import com.dcode.englishacademy.dto.request.StudentRequest;
import com.dcode.englishacademy.entity.StudentEntity;
import com.dcode.englishacademy.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping()
    public void createStudent(
            @RequestBody StudentRequest studentRequest
    ){
        studentService.createStudent(studentRequest);
    }

    @GetMapping("/{idStudent}")
    public StudentEntity getStudent(
            @PathVariable String idStudent
    ) {
        return  studentService.getStudent(idStudent);
    }

    @GetMapping()
    public List<StudentEntity> getAllStudents(){
        return studentService.getAllStudents();
    }




}
