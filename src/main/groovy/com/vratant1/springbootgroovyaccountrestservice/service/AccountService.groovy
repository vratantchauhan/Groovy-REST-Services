package com.vratant1.springbootgroovyaccountrestservice.service

import com.vratant1.springbootgroovyaccountrestservice.entity.Account

interface AccountService {

    List<Account> findAllAccountsService();
    Account findAccountByIdService(int id);
    Account findAccountByAccountNumberService(long accountNumber);
    Account saveAccountService(Account account);
    Account updateAccountService(Account account);
    boolean deleteAccountService(int id);
}