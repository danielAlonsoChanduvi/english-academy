package com.dcode.englishacademy.repository;

import com.dcode.englishacademy.entity.RoomEntity;
import com.dcode.englishacademy.entity.StudentEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RoomRepository {

    private List<RoomEntity> rooms = new ArrayList<>();

    public RoomRepository() {
        this.rooms.add(new RoomEntity(1,"RoomA"));
        this.rooms.add(new RoomEntity(2, "RoomB"));
        this.rooms.add(new RoomEntity(3, "RoomC"));
    }

    public List<RoomEntity> getAll() {
        return rooms;
    }

    public Boolean existsRoom(Integer roomId) {
        return rooms.stream()
                .filter(room -> room.getRoomId().equals(roomId))
                .findAny()
                .map(room -> Boolean.TRUE)
                .orElseGet(() -> Boolean.FALSE);
    }

    public void save(RoomEntity roomEntity) {

        if (existsRoom(roomEntity.getRoomId())) {
            RoomEntity roomFound = getRoomById(roomEntity.getRoomId());
            rooms.removeIf(room -> room.getRoomId() == roomFound.getRoomId());
            roomFound.setRoomName(roomEntity.getRoomName());
            rooms.add(roomFound);


        } else {
            rooms.add(roomEntity);
        }



    }

    public RoomEntity getRoomById(Integer idRoom) {
        return getAll().stream()
                .filter(roomEntity -> roomEntity.getRoomId() == idRoom).findAny()
                .orElseThrow(() -> new RuntimeException("Room not found."));
    }


    public void saveStudent(Integer roomId, StudentEntity studentEntity) {

        RoomEntity room = getRoomById(roomId);
        List<StudentEntity> students = room.getStudents();
        students.add(studentEntity);
        room.setStudents(students);

        save(room);



    }

}
