package com.example.BankProjectIronhack.Services;

import com.example.BankProjectIronhack.Models.Account.*;
import com.example.BankProjectIronhack.Models.Users.AccountHolder;
import com.example.BankProjectIronhack.Models.Users.ThirdParty;
import com.example.BankProjectIronhack.Models.Users.User;
import com.example.BankProjectIronhack.Repositories.AccountRepositories.AccountRepository;
import com.example.BankProjectIronhack.Repositories.AccountRepositories.SavingsRepository;
import com.example.BankProjectIronhack.Repositories.UserRepositories.AccountHolderRepository;
import com.example.BankProjectIronhack.Repositories.UserRepositories.AdminRepository;
import com.example.BankProjectIronhack.Repositories.UserRepositories.ThirdPartyRepository;
import com.example.BankProjectIronhack.Repositories.UserRepositories.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Objects;

@Service
public class AdminService {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ThirdPartyRepository thirdPartyRepository;

    @Autowired
    SavingsRepository savingsRepository;
    @Autowired
    AccountHolderRepository accountHolderRepository;
    @Autowired
    AdminRepository adminRepository;

    public Account createChecking(Checking checking) {
        if(accountHolderRepository.findById(checking.getId()).isPresent()) {
            Period checkAge = Period.between(checking.getPrimaryOwner().getDateOfBirth(), LocalDate.now());
            if (checkAge.getYears() < 24) {
                StudentChecking studentCheck =
                        new StudentChecking(checking.getBalance(),
                                checking.getSecretKey(),
                                checking.getPrimaryOwner());
                return accountRepository.save(studentCheck);
            } else {
                return accountRepository.save(checking);
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found");
    }
    public Account createSavings(Savings savings) {

        return accountRepository.save(savings);
    }

    public Account createCreditCard(CreditCard creditCard) {
        if(accountHolderRepository.findById(creditCard.getPrimaryOwner().getId()).isPresent()) {
            accountRepository.save(creditCard);
            return creditCard;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found");
    }

    public AccountHolder createAccountHolder(AccountHolder accountHolder) {
        accountHolderRepository.save(accountHolder);
        return accountHolder;
    }

//    WORKS
    public ThirdParty createThirdParty(ThirdParty thirdParty) {

        return thirdPartyRepository.save(thirdParty);
    }

    private List<Account> checkAccountBalance(AccountHolder accountHolder){
        if(accountHolderRepository.findById(accountHolder.getId()).isPresent()){
            return accountHolderRepository.findById(accountHolder.getId()).get().getPrimaryAccountList();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account Id not found");
    }


    public void  modifyBalance(Long accountId, BigDecimal balance){
        if(accountRepository.findById(accountId).isPresent()){

         accountRepository.findById(accountId).get().setBalance(balance);

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This account doesn't exist");
        }
    }

    public void deleteAccount(Long accountId) {
        if(accountRepository.findById(accountId).isPresent()){
            accountRepository.deleteById(accountId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This account doesn't exist");
        }
    }

}
