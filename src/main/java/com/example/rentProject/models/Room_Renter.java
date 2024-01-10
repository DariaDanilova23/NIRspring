package com.example.rentProject.models;
import java.util.List;

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

@Data
@Entity
@Table(name = "room_renter")
@AllArgsConstructor
@NoArgsConstructor
public class Room_Renter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //Первичный ключ для Платежа 
    @OneToMany(mappedBy = "roomRenter")
    private List<Payment> payments;

    //Вторичные ключи
    //зависимость от Арендатор
    @ManyToOne
    @JoinColumn(name = "renter_id") // Это поле для хранения внешнего ключа
    private Renter renter;
    //зависимость от Типа Арендатора
    @ManyToOne
    @JoinColumn(name = "typeRenter_id") // Это поле для хранения внешнего ключа
    private TypeOfRenter typeRenter;

    // ключ зависимость от Помещения 
    @ManyToOne
    @JoinColumn(name = "room_id") // Это поле для хранения внешнего ключа
    private Room room;
}
