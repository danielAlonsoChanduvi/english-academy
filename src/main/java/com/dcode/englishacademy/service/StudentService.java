package com.dcode.englishacademy.service;

import com.dcode.englishacademy.dto.request.StudentRequest;
import com.dcode.englishacademy.entity.StudentEntity;

import java.util.List;

public interface StudentService {

    //create a student
    void createStudent(StudentRequest studentRequest);
    //get details of a student
    StudentEntity getStudent(String studentId);

    //get all students
    List<StudentEntity> getAllStudents();
}
