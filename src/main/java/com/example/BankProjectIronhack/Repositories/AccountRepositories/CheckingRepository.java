package com.example.BankProjectIronhack.Repositories.AccountRepositories;

import com.example.BankProjectIronhack.Models.Account.Checking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckingRepository extends JpaRepository<Checking, Long> {
}
