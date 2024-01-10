package com.example.rentProject.services;

import com.example.rentProject.models.Building;
import com.example.rentProject.models.Room;
import com.example.rentProject.repository.BuildingRepository;

import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

@RequiredArgsConstructor
public class BuildingServices {
    private final BuildingRepository buildingRepository;
  
    public List<Building> getAllBuildings() {
        return buildingRepository.findAll();
    }

    public Optional<Building> getBuildingById(long buildingId) {
        return buildingRepository.findById(buildingId);
    }

    public void saveBuilding(Building building) {
        buildingRepository.save(building);
    }

    public void deleteBuilding(long buildingId) {
        buildingRepository.deleteById(buildingId);
    }

    public List<Room> getRoomsForBuilding(long buildingId) {
        Optional<Building> building = buildingRepository.findById(buildingId);
        return building.map(Building::getRooms).orElse(null);
    }
}
