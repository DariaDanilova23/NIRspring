package com.example.rentProject.repository;

import com.example.rentProject.models.Renter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RenterRepository extends JpaRepository<Renter, Long> {

}