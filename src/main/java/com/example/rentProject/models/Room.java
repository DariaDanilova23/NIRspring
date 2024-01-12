package com.example.rentProject.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "room")
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String number; //номер помещения
    private int entrance; //подъезд
    private int floor; //этаж
    private float x;
    private float y;
    private float z;
    private float square; //площадь
    private BigDecimal price; //стоимость аренды за кв.м
    private String wallMaterial; //материал стен
    private String ceilingMaterial;//материал потолка

    
    //Первичный ключ для Платежа
    @OneToMany(mappedBy = "room")
    private List<Wallet> wallets;

    //Первичный ключ для Аредатор_Помещение
    @OneToMany(mappedBy = "room")
    private List<Room_Renter> roomRenters;

    //Внешние ключи 
    //зависимость от типа помещения 
    @ManyToOne
    @JoinColumn(name = "typeOfRoom_id") // Это поле для хранения внешнего ключа
    private TypeOfRoom typeRoom ;

    //зависимость от строения 
    @ManyToOne
    @JoinColumn(name = "building_id") // Это поле для хранения внешнего ключа
    private Building building;

    //зависимость от владельца 
    @ManyToOne
    @JoinColumn(name = "owner_id") // Это поле для хранения внешнего ключа
    private Owner owner;
}
