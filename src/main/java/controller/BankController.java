package controller;

import dto.User;

import java.util.ArrayList;
import java.util.UUID;

public class BankController {

    private ArrayList<User> users = new ArrayList<>();

    public BankController() {
    }

    public void createUser(User user){
        this.users.add(user);
    }

    public User findUserByCardId(UUID cardId) throws Exception {
        for (User currentUser: this.users){
            if (currentUser.getCard().getId().equals(cardId)) {
                return currentUser;
            }
        }

        throw new Exception("User not found!");
    }

    public User findUserByAccountNumber(String accountNumber) throws Exception {
        for (User currentUser: this.users) {
            if (currentUser.getAccountNumber().equals(accountNumber)){
                return  currentUser;
            }
        }

        throw new Exception("User not found");
    }

}
