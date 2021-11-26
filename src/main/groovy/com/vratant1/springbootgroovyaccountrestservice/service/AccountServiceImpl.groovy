package com.vratant1.springbootgroovyaccountrestservice.service

import com.vratant1.springbootgroovyaccountrestservice.entity.Account
import com.vratant1.springbootgroovyaccountrestservice.repository.AccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service

@Service
class AccountServiceImpl implements AccountService{

    @Autowired
    AccountRepository accountRepository;

    @Override
    List<Account> findAllAccountsService() {
        accountRepository.findAll().toList()
    }

    @Override
    Account findAccountByIdService(int id) {
        accountRepository.findById(id)
    }

    @Override
    Account findAccountByAccountNumberService(long accountNumber) {
        accountRepository.findByAccountNumber(accountNumber)
    }

    @Override
    Account saveAccountService(Account account) {
        accountRepository.save(account)
    }

    @Override
    Account updateAccountService(Account account) {
        boolean accountExists = accountRepository.existsById(account.getId())
        if(accountExists==true){
            accountRepository.save(account)
        }else{
            null
        }

    }

    @Override
    boolean deleteAccountService(int id) {

        if(accountRepository.existsById(id)) {
            accountRepository.deleteById(id)
            true
        }
        false
    }
}
