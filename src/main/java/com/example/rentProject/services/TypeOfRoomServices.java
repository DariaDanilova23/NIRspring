package com.example.rentProject.services;

import com.example.rentProject.models.Room;
import com.example.rentProject.models.TypeOfRoom;
import com.example.rentProject.repository.TypeOfRoomRepository;

import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

@RequiredArgsConstructor
public class TypeOfRoomServices {
    private final TypeOfRoomRepository typeOfRoomRepository;
  
    public List<TypeOfRoom> getAllTypesOfRooms() {
        return typeOfRoomRepository.findAll();
    }

    public Optional<TypeOfRoom> getTypeOfRoomById(long typeId) {
        return typeOfRoomRepository.findById(typeId);
    }

    public void saveTypeOfRoom(TypeOfRoom typeOfRoom) {
        typeOfRoomRepository.save(typeOfRoom);
    }

    public void deleteTypeOfRoom(long typeId) {
        typeOfRoomRepository.deleteById(typeId);
    }


    public List<Room> getRoomsForTypeOfRoom(long typeId) {
        Optional<TypeOfRoom> typeOfRoom = typeOfRoomRepository.findById(typeId);
        return typeOfRoom.map(TypeOfRoom::getRooms).orElse(null);
    }
}
