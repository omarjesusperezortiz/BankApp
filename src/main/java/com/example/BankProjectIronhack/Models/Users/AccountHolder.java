package com.example.BankProjectIronhack.Models.Users;

import com.example.BankProjectIronhack.Models.Account.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AccountHolder extends User{
    @Embedded
    private Address primaryAddress;
    private String mailingAddress;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dateOfBirth;

    //Colocamos Listas de cuentas para poder visualizar los balances por AccountHolder
    @OneToMany
    @JsonIgnore
    private List<Account> primaryAccountList = new ArrayList<>();
    @OneToMany
    @JsonIgnore
    private List<Account> secondaryAccountList = new ArrayList<>();



    public AccountHolder(String name, String password, Address primaryAddress,LocalDate dateOfBirth) {
        super(name,password);
        setPrimaryAddress(primaryAddress);
        setDateOfBirth(dateOfBirth);

    }

    public AccountHolder(String name, String password, Address primaryAddress, String mailingAddress,LocalDate dateOfBirth) {
        super(name,password);
        setPrimaryAddress(primaryAddress);
        setDateOfBirth(dateOfBirth);
        setMailingAddress(mailingAddress);
    }

    public AccountHolder() {
    }

    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Account> getPrimaryAccountList() {
        return primaryAccountList;
    }

    public void setPrimaryAccountList(List<Account> primaryAccountList) {
        this.primaryAccountList = primaryAccountList;
    }

    public List<Account> getSecondaryAccountList() {
        return secondaryAccountList;
    }

    public void setSecondaryAccountList(List<Account> secondaryAccountList) {
        this.secondaryAccountList = secondaryAccountList;
    }
}