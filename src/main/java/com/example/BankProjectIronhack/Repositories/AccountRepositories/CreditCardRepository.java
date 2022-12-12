package com.example.BankProjectIronhack.Repositories.AccountRepositories;

import com.example.BankProjectIronhack.Models.Account.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}
