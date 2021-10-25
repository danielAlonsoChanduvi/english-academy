package com.dcode.englishacademy.service;

import com.dcode.englishacademy.dto.request.RoomRequest;
import com.dcode.englishacademy.entity.RoomEntity;

import java.util.List;

public interface RoomService {

    //create a room
    void createRoom(RoomRequest roomRequest);
    //get details of a room
    RoomEntity getRoom(Integer roomId);

    //get all rooms
    List<RoomEntity> getAllRooms();


    //assign student in a room
    void assignStudentToRoom(Integer roomId, String studentId);


}
