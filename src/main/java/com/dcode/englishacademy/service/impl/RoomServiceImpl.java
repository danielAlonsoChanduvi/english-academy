package com.dcode.englishacademy.service.impl;

import com.dcode.englishacademy.dto.request.RoomRequest;
import com.dcode.englishacademy.entity.RoomEntity;
import com.dcode.englishacademy.entity.StudentEntity;
import com.dcode.englishacademy.repository.RoomRepository;
import com.dcode.englishacademy.repository.StudentRespository;
import com.dcode.englishacademy.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {


    private final RoomRepository roomRepository;
    private final StudentRespository studentRespository;

    public RoomServiceImpl(RoomRepository roomRepository, StudentRespository studentRespository) {
        this.roomRepository = roomRepository;
        this.studentRespository = studentRespository;
    }


    @Override
    public void createRoom(RoomRequest roomRequest) {

        RoomEntity roomEntity =
                new RoomEntity(roomRequest.getRoomId(),roomRequest.getRoomName());

        roomRepository.save(roomEntity);
    }

    @Override
    public RoomEntity getRoom(Integer roomId) {
        return roomRepository.getRoomById(roomId);
    }

    @Override
    public List<RoomEntity> getAllRooms() {
        return roomRepository.getAll();
    }

    @Override
    public void assignStudentToRoom(Integer roomId, String studentId) {

        StudentEntity studentById = studentRespository.getStudentById(studentId);
        roomRepository.saveStudent(roomId,studentById);
    }
}
