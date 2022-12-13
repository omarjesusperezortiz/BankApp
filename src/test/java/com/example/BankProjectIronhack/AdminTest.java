package com.example.BankProjectIronhack;
import com.example.BankProjectIronhack.Models.Account.CreditCard;
import com.example.BankProjectIronhack.Models.Account.Savings;
import com.example.BankProjectIronhack.Models.Account.StudentChecking;
import com.example.BankProjectIronhack.Models.Users.AccountHolder;
import com.example.BankProjectIronhack.Models.Users.Address;
import com.example.BankProjectIronhack.Models.Users.Admin;
import com.example.BankProjectIronhack.Models.Users.ThirdParty;
import com.example.BankProjectIronhack.Repositories.AccountRepositories.AccountRepository;
import com.example.BankProjectIronhack.Repositories.AccountRepositories.SavingsRepository;
import com.example.BankProjectIronhack.Repositories.UserRepositories.AccountHolderRepository;
import com.example.BankProjectIronhack.Repositories.UserRepositories.AdminRepository;
import com.example.BankProjectIronhack.Repositories.UserRepositories.UserRepository;
import com.example.BankProjectIronhack.Services.AdminService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class AdminTest {
    @Autowired
    WebApplicationContext context;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    AccountHolderRepository accountHolderRepository;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    SavingsRepository savingsRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AdminService adminService;
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp(){

        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        objectMapper.findAndRegisterModules();
    }
    @AfterEach
    void tearDown() {
    }


    @Test
    public void createThirdPartyTest() throws Exception {
        ThirdParty thirdParty = new ThirdParty("asdfasdf");

        String bodyRequest = objectMapper.writeValueAsString(thirdParty);
        MvcResult result = (MvcResult) mockMvc.perform(post("/create-third-party")
                .content(bodyRequest).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated()).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("hashedKey"));
    }

}