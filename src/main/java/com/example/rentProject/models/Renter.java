package com.example.rentProject.models;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "renter")
@AllArgsConstructor
@NoArgsConstructor
public class Renter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String FIO;

    //Первичный ключ для Арендатор_Помещение 
    @OneToMany(mappedBy = "renter")
    private List<Room_Renter> roomRenters;
}
