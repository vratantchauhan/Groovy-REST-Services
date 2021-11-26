package com.vratant1.springbootgroovyaccountrestservice.entity

import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import lombok.ToString

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="account")
@NoArgsConstructor
@ToString
@AllArgsConstructor
class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id

    @Column(name="account_holder_name")
    String accountHolderName;

    @Column(name="account_number")
    long accountNumber;

    @Column(name="account_type")
    String accountType;

    @Column(name="account_balance")
    double accountBalance;
}
