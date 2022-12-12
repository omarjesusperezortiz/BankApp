package com.example.BankProjectIronhack.Repositories.AccountRepositories;

import com.example.BankProjectIronhack.Models.Account.StudentChecking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCheckRepository extends JpaRepository<StudentChecking,Long> {
}
