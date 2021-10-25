package com.dcode.englishacademy.controller;

import com.dcode.englishacademy.dto.request.RoomRequest;
import com.dcode.englishacademy.entity.RoomEntity;
import com.dcode.englishacademy.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    private final RoomService roomService;


    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping()
    public void createRoom(
            @RequestBody RoomRequest roomRequest
    ) {
        roomService.createRoom(roomRequest);
    }


    @GetMapping("/idRoom")
    public RoomEntity getRoom(
            @PathVariable Integer idRoom
    ) {
        return roomService.getRoom(idRoom);
    }

    @GetMapping()
    public List<RoomEntity> getAllRooms() {
        return roomService.getAllRooms();
    }


    @PostMapping("/student")
    public  void assignStudentToRoom(
            @RequestParam Integer idRoom,
            @RequestParam String idStudent
    ) {
        roomService.assignStudentToRoom(idRoom,idStudent);
    }


}
