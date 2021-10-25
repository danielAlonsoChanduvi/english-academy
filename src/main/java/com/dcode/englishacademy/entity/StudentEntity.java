package com.dcode.englishacademy.entity;

public class StudentEntity {

    private String studentId;
    private String studentFullName;
    private Integer studentAge;

    public StudentEntity(String studentId, String studentFullName, Integer studentAge) {
        this.studentId = studentId;
        this.studentFullName = studentFullName;
        this.studentAge = studentAge;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentFullName() {
        return studentFullName;
    }

    public void setStudentFullName(String studentFullName) {
        this.studentFullName = studentFullName;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }
}
