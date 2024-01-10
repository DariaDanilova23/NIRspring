package com.example.rentProject.services;

import com.example.rentProject.models.Payment;
import com.example.rentProject.models.Room_Renter;
import com.example.rentProject.models.Wallet;
import com.example.rentProject.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

@RequiredArgsConstructor
public class PaymentServices {
    private final PaymentRepository paymentRepository;

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Optional<Payment> getPaymentById(long paymentId) {
        return paymentRepository.findById(paymentId);
    }

    public void savePayment(Payment payment) {
        paymentRepository.save(payment);
    }

    public void deletePayment(long paymentId) {
        paymentRepository.deleteById(paymentId);
    }


    public Wallet getWalletForPayment(long paymentId) {
        Optional<Payment> payment = paymentRepository.findById(paymentId);
        return payment.map(Payment::getWallet).orElse(null);
    }

    public Room_Renter getRoomRenterForPayment(long paymentId) {
        Optional<Payment> payment = paymentRepository.findById(paymentId);
        return payment.map(Payment::getRoomRenter).orElse(null);
    }
}
