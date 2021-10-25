package com.dcode.englishacademy.service.impl;

import com.dcode.englishacademy.dto.request.StudentRequest;
import com.dcode.englishacademy.entity.StudentEntity;
import com.dcode.englishacademy.repository.StudentRespository;
import com.dcode.englishacademy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRespository studentRespository;

    public StudentServiceImpl(StudentRespository studentRespository) {
        this.studentRespository = studentRespository;
    }

    @Override
    public void createStudent(StudentRequest studentRequest) {

        StudentEntity studentEntity =
                new StudentEntity(
                        studentRequest.getDni(),
                        studentRequest.getFullname(),
                        studentRequest.getAge());

        studentRespository.save(studentEntity);
    }

    @Override
    public StudentEntity getStudent(String studentId) {

        return studentRespository.getStudentById(studentId);
    }

    @Override
    public List<StudentEntity> getAllStudents() {
        return studentRespository.getAll();
    }
}
