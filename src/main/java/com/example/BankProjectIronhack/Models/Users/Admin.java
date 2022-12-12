package com.example.BankProjectIronhack.Models.Users;
import jakarta.persistence.Entity;

@Entity
public class Admin extends User {

    public Admin(String name, String password) {
        super(name, password);
    }

    public Admin() {
    }
}