package com.example.rentProject.repository;

import com.example.rentProject.models.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository extends JpaRepository<Building, Long> {

}