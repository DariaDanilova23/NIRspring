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
@Table(name = "building")
@AllArgsConstructor
@NoArgsConstructor
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String address; //адрес
    private float x;
    private float y;
    private float z;
    private float width; //ширина
    private float height; //высота
    private float depth; //глубина

    //Первичный ключ для Помещения 
    @OneToMany(mappedBy = "building")
    private List<Room> rooms;
}
