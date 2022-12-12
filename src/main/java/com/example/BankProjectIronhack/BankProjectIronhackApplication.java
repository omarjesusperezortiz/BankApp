package com.example.BankProjectIronhack;

import com.example.BankProjectIronhack.Models.Account.Account;
import com.example.BankProjectIronhack.Models.Account.Checking;
import com.example.BankProjectIronhack.Models.Account.StudentChecking;
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
@RestController
public class BankProjectIronhackApplication {

	@Autowired
	AccountRepository accountRepository;
	@Autowired
	ThirdPartyRepository thirdPartyRepository;

public static void main(String[] args) {
		SpringApplication.run(BankProjectIronhackApplication.class, args);
	}


//	LocalDate birthDate = LocalDate.of(Integer.parseInt("1993"), Integer.parseInt("7"), Integer.parseInt("26"));
//	Address addressOmar = new Address(
//			"Carrer de julia portet",
//			"Barcelona",
//			"08002");
//	AccountHolder omar=	new AccountHolder("Omar","thisisapassword",addressOmar,birthDate);
//
//	Checking checking1 = new Checking (
//			new BigDecimal(100),
//			"asdfds",omar);
//	;
}

