package com.example.BankProjectIronhack;

import com.example.BankProjectIronhack.Repositories.AccountRepositories.AccountRepository;
import com.example.BankProjectIronhack.Repositories.UserRepositories.AccountHolderRepository;
import com.example.BankProjectIronhack.Repositories.UserRepositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
public class AccountHolderTest {

    @Autowired
    WebApplicationContext context;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountHolderRepository accountHolderRepository;
    @Autowired
    protected UserRepository userRepository;
}
