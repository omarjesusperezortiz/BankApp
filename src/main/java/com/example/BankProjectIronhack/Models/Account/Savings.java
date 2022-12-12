package com.example.BankProjectIronhack.Models.Account;
import java.time.LocalDate;
import com.example.BankProjectIronhack.Models.Users.AccountHolder;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;
import org.hibernate.Hibernate;
import java.math.BigDecimal;
import java.util.Objects;
@Entity
public class Savings extends Account{

    @DecimalMax(value = "0.5")
    private BigDecimal interestRate = BigDecimal.valueOf(0.0025);
    @DecimalMin(value = "100.00")
    @DecimalMax(value = "1000.00")
    private BigDecimal minimumBalance = BigDecimal.valueOf(1000.00);


    public Savings(BigDecimal balance,
                   AccountHolder primaryOwner,
                   String secretKey)
    {
        super(balance, primaryOwner, secretKey);
    }

    public Savings(BigDecimal balance,
                   AccountHolder primaryOwner,
                   String secretKey, BigDecimal minimumBalance)
    {
        super(balance, primaryOwner, secretKey);
        setMinimumBalance(minimumBalance);
    }

    public Savings(BigDecimal balance,
                   AccountHolder primaryOwner,
                   String secretKey, BigDecimal minimumBalance, BigDecimal interestRate)
    {
        super(balance, primaryOwner, secretKey);
        setMinimumBalance(minimumBalance);
        setInterestRate(interestRate);
    }

    public Savings(BigDecimal balance,
                   AccountHolder primaryOwner, AccountHolder secondaryOwner,
                   String secretKey)
    {
        super(balance, primaryOwner,secondaryOwner, secretKey);
    }

    public Savings(BigDecimal balance,
                   AccountHolder primaryOwner, AccountHolder secondaryOwner,
                   String secretKey, BigDecimal minimumBalance)
    {
        super(balance, primaryOwner,secondaryOwner, secretKey);
        setMinimumBalance(minimumBalance);
    }

    public Savings(BigDecimal balance,
                   AccountHolder primaryOwner,  AccountHolder secondaryOwner,
                   String secretKey, BigDecimal minimumBalance, BigDecimal interestRate)
    {
        super(balance, primaryOwner,secondaryOwner, secretKey);
        setMinimumBalance(minimumBalance);
        setInterestRate(interestRate);
    }


    public Savings() {}

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(BigDecimal minimumBalance) {
        this.minimumBalance = minimumBalance;
    }
}