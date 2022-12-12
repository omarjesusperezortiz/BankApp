package com.example.BankProjectIronhack.Repositories.UserRepositories;

import com.example.BankProjectIronhack.Models.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
