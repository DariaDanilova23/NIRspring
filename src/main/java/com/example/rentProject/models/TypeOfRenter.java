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
@Table(name = "typeOfRenter")
@AllArgsConstructor
@NoArgsConstructor
public class TypeOfRenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    //Первичный ключ для Помещения 
    @OneToMany(mappedBy = "typeRenter")
    private List<Room_Renter> roomRenters;

    public TypeOfRenter(String name) {
        this.name = name;
    }
}
