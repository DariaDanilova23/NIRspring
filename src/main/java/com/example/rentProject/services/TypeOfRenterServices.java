package com.example.rentProject.services;

import com.example.rentProject.models.Room_Renter;
import com.example.rentProject.models.TypeOfRenter;
import com.example.rentProject.repository.TypeOfRenterRepository;

import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

@RequiredArgsConstructor
public class TypeOfRenterServices {
    private final TypeOfRenterRepository typeOfRenterRepository;
  
    public List<TypeOfRenter> getAllTypesOfRenters() {
        return typeOfRenterRepository.findAll();
    }

    public Optional<TypeOfRenter> getTypeOfRenterById(long typeId) {
        return typeOfRenterRepository.findById(typeId);
    }

    public void saveTypeOfRenter(TypeOfRenter typeOfRenter) {
        typeOfRenterRepository.save(typeOfRenter);
    }

    public void deleteTypeOfRenter(long typeId) {
        typeOfRenterRepository.deleteById(typeId);
    }

    public List<Room_Renter> getRoomRentersForTypeOfRenter(long typeId) {
        Optional<TypeOfRenter> typeOfRenter = typeOfRenterRepository.findById(typeId);
        return typeOfRenter.map(TypeOfRenter::getRoomRenters).orElse(null);
    }
}
