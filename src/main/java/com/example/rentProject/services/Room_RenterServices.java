package com.example.rentProject.services;

import com.example.rentProject.models.Payment;
import com.example.rentProject.models.Renter;
import com.example.rentProject.models.Room;
import com.example.rentProject.models.Room_Renter;
import com.example.rentProject.models.TypeOfRenter;
import com.example.rentProject.repository.Room_RenterRepository;

import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

@RequiredArgsConstructor
public class Room_RenterServices {
    private final Room_RenterRepository roomRenterRepository;
    public List<Room_Renter> getAllRoomRenters() {
        return roomRenterRepository.findAll();
    }

    public Optional<Room_Renter> getRoomRenterById(long roomRenterId) {
        return roomRenterRepository.findById(roomRenterId);
    }

    public void saveRoomRenter(Room_Renter roomRenter) {
        roomRenterRepository.save(roomRenter);
    }

    public void deleteRoomRenter(long roomRenterId) {
        roomRenterRepository.deleteById(roomRenterId);
    }

    // Дополнительные методы, если необходимо

    public List<Payment> getPaymentsForRoomRenter(long roomRenterId) {
        Optional<Room_Renter> roomRenter = roomRenterRepository.findById(roomRenterId);
        return roomRenter.map(Room_Renter::getPayments).orElse(null);
    }

    public Renter getRenterForRoomRenter(long roomRenterId) {
        Optional<Room_Renter> roomRenter = roomRenterRepository.findById(roomRenterId);
        return roomRenter.map(Room_Renter::getRenter).orElse(null);
    }

    public TypeOfRenter getTypeOfRenterForRoomRenter(long roomRenterId) {
        Optional<Room_Renter> roomRenter = roomRenterRepository.findById(roomRenterId);
        return roomRenter.map(Room_Renter::getTypeRenter).orElse(null);
    }

    public Room getRoomForRoomRenter(long roomRenterId) {
        Optional<Room_Renter> roomRenter = roomRenterRepository.findById(roomRenterId);
        return roomRenter.map(Room_Renter::getRoom).orElse(null);
    }

}
