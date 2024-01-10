package com.example.rentProject.services;

import com.example.rentProject.models.Renter;
import com.example.rentProject.models.Room_Renter;
import com.example.rentProject.repository.RenterRepository;

import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

@RequiredArgsConstructor
public class RenterServices {
    private final RenterRepository renterRepository;
    public List<Renter> getAllRenters() {
        return renterRepository.findAll();
    }

    public Optional<Renter> getRenterById(long renterId) {
        return renterRepository.findById(renterId);
    }

    public void saveRenter(Renter renter) {
        renterRepository.save(renter);
    }

    public void deleteRenter(long renterId) {
        renterRepository.deleteById(renterId);
    }


    public List<Room_Renter> getRoomRentersForRenter(long renterId) {
        Optional<Renter> renter = renterRepository.findById(renterId);
        return renter.map(Renter::getRoomRenters).orElse(null);
    }
}
