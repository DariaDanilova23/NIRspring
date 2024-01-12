package com.example.rentProject.services;

import com.example.rentProject.models.Owner;
import com.example.rentProject.models.Room;
import com.example.rentProject.repository.OwnerRepository;

import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

@RequiredArgsConstructor
public class OwnerServices {
    private final OwnerRepository ownerRepository;

    public Owner saveOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    public Owner getOwnerById(long ownerId) {
        return ownerRepository.findById(ownerId).orElse(null);
    }

    public void deleteOwner(long ownerId) {
        ownerRepository.deleteById(ownerId);
    }

}
