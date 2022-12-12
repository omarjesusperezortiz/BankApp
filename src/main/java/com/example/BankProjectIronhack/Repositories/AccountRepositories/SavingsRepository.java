package com.example.BankProjectIronhack.Repositories.AccountRepositories;

import com.example.BankProjectIronhack.Models.Account.Savings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingsRepository extends JpaRepository<Savings, Long> {
}
