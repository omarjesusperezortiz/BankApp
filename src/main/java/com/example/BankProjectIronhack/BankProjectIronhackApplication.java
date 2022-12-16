package com.example.BankProjectIronhack;

import com.example.BankProjectIronhack.Models.Account.*;
import com.example.BankProjectIronhack.Models.Users.AccountHolder;
import com.example.BankProjectIronhack.Models.Users.Address;
import com.example.BankProjectIronhack.Models.Users.Admin;
import com.example.BankProjectIronhack.Models.Users.ThirdParty;
import com.example.BankProjectIronhack.Repositories.AccountRepositories.AccountRepository;
import com.example.BankProjectIronhack.Repositories.AccountRepositories.CheckingRepository;
import com.example.BankProjectIronhack.Repositories.UserRepositories.AccountHolderRepository;
import com.example.BankProjectIronhack.Repositories.UserRepositories.AdminRepository;
import com.example.BankProjectIronhack.Repositories.UserRepositories.ThirdPartyRepository;
import com.example.BankProjectIronhack.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class BankProjectIronhackApplication implements CommandLineRunner {

	@Autowired
	AccountRepository accountRepository;
	@Autowired
	AccountHolderRepository accountHolderRepository;
public static void main(String[] args) {
		SpringApplication.run(BankProjectIronhackApplication.class, args);
	}

//	DE EJEMPLO SOLO PARA TESTEAR EL GETTER EN POSTMAN
@Override
public void run(String... args) throws Exception {

	//CREACION EN MYSQL WORKBENCH FUNCIONA CORRECTAMENTE

		Address address = new Address("Carrer de Julia Portet","Barcelona","08002");
		AccountHolder user1 = new AccountHolder("Omar","password",address,LocalDate.of(1993,07,26));
		AccountHolder user2 = new AccountHolder("Jose","password",address,LocalDate.of(1993,07,26));
		AccountHolder user3 = new AccountHolder("Juanito","password",address,LocalDate.of(1993,07,26));

		accountHolderRepository.saveAll(List.of(user1, user2, user3));

	Savings savings1 = new Savings(BigDecimal.valueOf(1000),user1,"secretKey");
	Savings savings2 = new Savings(BigDecimal.valueOf(300),user1,"secretKey");
	Savings savings3 = new Savings(BigDecimal.valueOf(300),user1,"secretKey");
	Checking checking = new Checking(BigDecimal.valueOf(1000),"secretKey",user2);
	CreditCard creditCard = new CreditCard(BigDecimal.valueOf(1000),user3,"secretKey");


	accountRepository.saveAll(List.of(savings1,savings2,savings3,checking,creditCard));

}

}

