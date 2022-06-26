package controller;

import dto.User;
import dto.UserCard;

import javax.swing.*;

public class AtmController {

    private BankController bankController;
    private UserCard activeCard;
private boolean isValidated = false;
    public AtmController() {

    }

    public AtmController(UserCard activeCard) {
        this.activeCard = activeCard;
    }

    public void insertCard(UserCard userCard) {
        this.activeCard = userCard;
    }

    public String validateCard() {
        try{
            User currentUser = bankController.findUserByCardId(this.activeCard.getId());

            int cardPin = Integer.parseInt(
                    JOptionPane.showInputDialog("Welcome " + currentUser.getName()+ ", Please enter your pin: ")
            );
            this.isValidated = this.activeCard.isPinValid(cardPin);
            if (!this.isValidated) return "Invalid Pin";

        } catch (Exception e) {
        return "Error" + e.getMessage();
        }

        return "Card validated successfully";
    }


    public void setBankController(BankController bankController) {
        this.bankController = bankController;
    }

    public String deposit() {
        if(!isValidated) return "Please validate your card";
        double amountToDeposit = Double.parseDouble(
                JOptionPane.showInputDialog("Enter amount to deposit: "));
        this.activeCard.setBalance(this.activeCard.getBalance() + amountToDeposit);

        return "Deposit successful, new balance: " + this.activeCard.getBalance();
    }

    public String withdraw() {
        if(!isValidated) return "Please validate your card";
        double amountToWithdraw = Double.parseDouble(
                JOptionPane.showInputDialog("Enter amount to withdraw: "));

        double currentBalance = this.activeCard.getBalance();
        if (currentBalance < amountToWithdraw) return "Insufficient balance";

        this.activeCard.setBalance(currentBalance - amountToWithdraw);

        return "Withdrawal successful, new balance: " + this.activeCard.getBalance();
    }

    public String removeCard() {
        this.activeCard = null;
        this.isValidated = false;

        return "Good bye!";
    }

}
