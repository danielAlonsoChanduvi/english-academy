package com.dcode.englishacademy.repository;

import com.dcode.englishacademy.entity.StudentEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRespository {

    private List<StudentEntity> students = new ArrayList<>();

    public StudentRespository() {
        this.students.add(new StudentEntity("71195634","Daniel Alonso Chanduvi Siesquen",24));
        this.students.add(new StudentEntity("71192123","Jorge Chavez Linares",20));
        this.students.add(new StudentEntity("12123212", "José Chavez Orosco", 18));

    }

    public List<StudentEntity> getAll() {
        return students;
    }

    public StudentEntity getStudentById(String studentId) {
        return students.stream()
                .filter(studentEntity -> studentEntity.getStudentId().equalsIgnoreCase(studentId))
                .findAny()
                .orElseGet(() -> new StudentEntity(null,null,null));
                //.orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Boolean existsStudent(String studentId) {
        return students.stream()
                .filter(student -> student.getStudentId().equalsIgnoreCase(studentId))
                .findAny()
                .map(student -> Boolean.TRUE)
                .orElseGet(() -> Boolean.FALSE);
    }

    public void save(StudentEntity studentEntity) {
        if (existsStudent(studentEntity.getStudentId())){

            StudentEntity studentFound = getStudentById(studentEntity.getStudentId());
            students.removeIf(student -> student.getStudentId().equalsIgnoreCase(studentEntity.getStudentId()));
            studentFound.setStudentAge(studentEntity.getStudentAge());
            studentFound.setStudentFullName(studentEntity.getStudentFullName());
            students.add(studentFound);


        } else {
            getAll().add(studentEntity);
        }

    }


}
