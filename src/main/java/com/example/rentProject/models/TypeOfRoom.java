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
@Table(name = "typeOfRoom")
@AllArgsConstructor
@NoArgsConstructor
public class TypeOfRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    //Первичный ключ для Помещения 
    @OneToMany(mappedBy = "typeRoom")
    private List<Room> rooms;

}
