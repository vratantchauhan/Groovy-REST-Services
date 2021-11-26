package com.vratant1.springbootgroovyaccountrestservice.controller

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.vratant1.springbootgroovyaccountrestservice.entity.Account
import com.vratant1.springbootgroovyaccountrestservice.repository.AccountRepository
import com.vratant1.springbootgroovyaccountrestservice.service.AccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/acc")
class AccountController {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    AccountService accountServiceImpl;

    @GetMapping("/all")
    ResponseEntity<Account> getAllAccounts(){
        new ResponseEntity<Account>(accountServiceImpl.findAllAccountsService(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Account> getAllAccounts(@PathVariable int id){
        new ResponseEntity<Account>(accountServiceImpl.findAccountByIdService(id),HttpStatus.OK)

    }

    @GetMapping("accountNumber/{accountNumber}")
    ResponseEntity<Account> getAllAccounts(@PathVariable long accountNumber){
        new ResponseEntity<Account>(accountServiceImpl.findAccountByAccountNumberService(accountNumber),HttpStatus.OK)

    }

    @PostMapping("/save")
    ResponseEntity<String> saveAccount(@RequestBody Account account){
        Account accountSaved = accountServiceImpl.saveAccountService(account)
        if(accountSaved!=null){
            new ResponseEntity<String>("Account Saved Successfully.", HttpStatus.ACCEPTED)
        }else{
            new ResponseEntity<String>("Account could not be saved.", HttpStatus.ACCEPTED)
        }

    }

    @PutMapping("/update")
    ResponseEntity<String> updateAccount(@RequestBody Account account){
        Account accountExists = accountServiceImpl.updateAccountService(account)
        if(accountExists!=null){
            new ResponseEntity<String>("Account Updated Successfully.", HttpStatus.ACCEPTED)
        }else{
            new ResponseEntity<String>("Account does not exist.", HttpStatus.BAD_REQUEST)
        }

    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteAccount(@PathVariable int id){
        boolean deleted = accountServiceImpl.deleteAccountService(id)
        if(deleted==true){
            new ResponseEntity<String>("Account deleted Successfully.",HttpStatus.ACCEPTED);
        }else{
            new ResponseEntity<String>("Account does not exist.",HttpStatus.BAD_REQUEST);
        }


    }
}
