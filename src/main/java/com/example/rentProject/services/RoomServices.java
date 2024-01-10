package com.example.rentProject.services;

import com.example.rentProject.models.Building;
import com.example.rentProject.models.Room;
import com.example.rentProject.models.Room_Renter;
import com.example.rentProject.models.TypeOfRoom;
import com.example.rentProject.models.Wallet;
import com.example.rentProject.repository.RoomRepository;

import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

@RequiredArgsConstructor
public class RoomServices {
    private final RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Optional<Room> getRoomById(long roomId) {
        return roomRepository.findById(roomId);
    }

    public void saveRoom(Room room) {
        roomRepository.save(room);
    }

    public void deleteRoom(long roomId) {
        roomRepository.deleteById(roomId);
    }


    public List<Wallet> getWalletsForRoom(long roomId) {
        Optional<Room> room = roomRepository.findById(roomId);
        return room.map(Room::getWallets).orElse(null);
    }

    public List<Room_Renter> getRoomRentersForRoom(long roomId) {
        Optional<Room> room = roomRepository.findById(roomId);
        return room.map(Room::getRoomRenters).orElse(null);
    }

    public TypeOfRoom getTypeOfRoomForRoom(long roomId) {
        Optional<Room> room = roomRepository.findById(roomId);
        return room.map(Room::getTypeRoom).orElse(null);
    }

    public Building getBuildingForRoom(long roomId) {
        Optional<Room> room = roomRepository.findById(roomId);
        return room.map(Room::getBuilding).orElse(null);
    }
}
