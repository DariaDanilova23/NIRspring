package com.example.rentProject.models;
//import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "wallet")
@AllArgsConstructor
@NoArgsConstructor
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private BigDecimal debt; //задолженность 
    private BigDecimal accountBalance; //остаток на счету

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_modified_date")
    private Date lastModifiedDate;

    //Первичный ключ для Платежа
    @OneToMany(mappedBy = "wallet")
    private List<Payment> payments;

    //Вторичный ключ зависимость от Помещения 
    @ManyToOne
    @JoinColumn(name = "room_id") // Это поле для хранения внешнего ключа
    private Room room;
}
