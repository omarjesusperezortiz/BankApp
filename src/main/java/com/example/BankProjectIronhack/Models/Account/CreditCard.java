package com.example.BankProjectIronhack.Models.Account;
import com.example.BankProjectIronhack.Models.Users.AccountHolder;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.Getter;
import java.math.BigDecimal;
@Entity
public class CreditCard extends Account {
    @DecimalMin(value = "100")
    @DecimalMax(value = "100000")
    private BigDecimal creditLimit = BigDecimal.valueOf(100);


    @DecimalMin(value = "0.1")
    @DecimalMax(value = "0.2")
    private BigDecimal interestRate = BigDecimal.valueOf(0.2);

    //Constructor con default values y 1 owner

    public CreditCard(BigDecimal balance,
                      AccountHolder primaryOwner,
                      String secretKey)
    {
        super(balance,primaryOwner,secretKey);
    }
    //Constructor con default values y 2 owners
    public CreditCard(BigDecimal balance,
                      AccountHolder primaryOwner, AccountHolder secondaryOwner,
                      String secretKey)
    {
        super(balance,primaryOwner,secondaryOwner,secretKey);
    }

    //Constructor con interest default y assign creditLimit y 1 owner
    public CreditCard(BigDecimal balance,
                      AccountHolder primaryOwner,
                      String secretKey, BigDecimal creditLimit)
    {
        super(balance,primaryOwner,secretKey);
        setCreditLimit(creditLimit);
    }

    //Constructor con interest default y assign creditLimit y 2 owners
    public CreditCard(BigDecimal balance,
                      AccountHolder primaryOwner, AccountHolder secondaryOwner,
                      String secretKey, BigDecimal creditLimit)
    {
        super(balance,primaryOwner,secondaryOwner,secretKey);
        setCreditLimit(creditLimit);
    }

    //Constructor con assign creditLimit y interestRate y 1 owner
    public CreditCard(BigDecimal balance,
                      AccountHolder primaryOwner,
                      String secretKey, BigDecimal creditLimit, BigDecimal interestRate)
    {
        super(balance,primaryOwner,secretKey);
        setCreditLimit(creditLimit);
        setInterestRate(interestRate);
    }

    //Constructor con assign creditLimit y interestRate y 1 owner
    public CreditCard(BigDecimal balance,
                      AccountHolder primaryOwner, AccountHolder secondaryOwner,
                      String secretKey, BigDecimal creditLimit, BigDecimal interestRate)
    {
        super(balance,primaryOwner,secondaryOwner,secretKey);
        setCreditLimit(creditLimit);
        setInterestRate(interestRate);
    }

    public CreditCard() {
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }
}