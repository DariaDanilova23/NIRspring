package com.example.rentProject.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@Entity
@Table(name = "payment")
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private BigDecimal price;
    private String creditAccount; //счёт зачисления
    private String debitAccount; //счёт списания 

    //Внешние ключи 
    //зависимость от Кошелька
    @ManyToOne
    @JoinColumn(name = "wallet_id") // Это поле для хранения внешнего ключа
    private Wallet wallet;

    //зависимость от Арендатор_Помещение
    @ManyToOne
    @JoinColumn(name = "room_renter_id") // Это поле для хранения внешнего ключа
    private Room_Renter roomRenter;

}
