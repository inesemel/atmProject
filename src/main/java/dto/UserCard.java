package dto;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class UserCard {
    public final UUID id;
    private double balance;
    private final Date expiryDate;
    private int pin;
    private long cardNumber;

    public UserCard(Date expiryDate, double balance, int pin) {
        this.id = UUID.randomUUID();
        this.balance = balance;
        this.expiryDate = expiryDate;
        this.pin = pin;
        this.cardNumber = this.generateCardNumber();
    }

    private long generateCardNumber() {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(10);

    }

    public UserCard(UUID id, Date expiryDate, double balance, int pin, long cardNumber) {
        this.id = id;
        this.balance = balance;
        this.expiryDate = expiryDate;
        this.pin = pin;
        this.cardNumber = cardNumber;
    }

    public UUID getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public boolean isPinValid(int cardPin) {
        return this.pin == cardPin;
    }
}
