package com.example.rentProject.services;

import com.example.rentProject.models.Payment;
import com.example.rentProject.models.Room;
import com.example.rentProject.models.Wallet;
import com.example.rentProject.repository.WalletRepository;

import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service

@RequiredArgsConstructor
public class WalletServices {
    private final WalletRepository walletRepository;

    public List<Wallet> getAllWallets() {
        return walletRepository.findAll();
    }

    public Optional<Wallet> getWalletById(long walletId) {
        return walletRepository.findById(walletId);
    }

    public void saveWallet(Wallet wallet) {
        walletRepository.save(wallet);
    }

    public void deleteWallet(long walletId) {
        walletRepository.deleteById(walletId);
    }


    public List<Payment> getPaymentsForWallet(long walletId) {
        Optional<Wallet> wallet = walletRepository.findById(walletId);
        return wallet.map(Wallet::getPayments).orElse(null);
    }

    public BigDecimal getAccountBalance(long walletId) {
        Optional<Wallet> wallet = walletRepository.findById(walletId);
        return wallet.map(Wallet::getAccountBalance).orElse(null);
    }

    public BigDecimal getDebt(long walletId) {
        Optional<Wallet> wallet = walletRepository.findById(walletId);
        return wallet.map(Wallet::getDebt).orElse(null);
    }

    public Date getLastModifiedDate(long walletId) {
        Optional<Wallet> wallet = walletRepository.findById(walletId);
        return wallet.map(Wallet::getLastModifiedDate).orElse(null);
    }

    public Room getRoomForWallet(long walletId) {
        Optional<Wallet> wallet = walletRepository.findById(walletId);
        return wallet.map(Wallet::getRoom).orElse(null);
    }
}
