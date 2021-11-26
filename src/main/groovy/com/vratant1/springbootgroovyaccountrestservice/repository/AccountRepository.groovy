package com.vratant1.springbootgroovyaccountrestservice.repository

import com.vratant1.springbootgroovyaccountrestservice.entity.Account
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param

interface AccountRepository extends JpaRepository<Account,Integer>{

    Account findByAccountNumber(@Param("accountNumber") long accountNumber)
}