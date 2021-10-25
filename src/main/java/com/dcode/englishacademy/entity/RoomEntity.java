package com.dcode.englishacademy.entity;

import java.util.ArrayList;
import java.util.List;

public class RoomEntity {
    private Integer roomId;
    private String roomName;
    private List<StudentEntity> students = new ArrayList<>();

    public RoomEntity(Integer roomId, String roomName) {
        this.roomId = roomId;
        this.roomName = roomName;
    }

    public RoomEntity(Integer roomId, String roomName, List<StudentEntity> students) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.students = students;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public List<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(List<StudentEntity> students) {
        this.students = students;
    }
}
