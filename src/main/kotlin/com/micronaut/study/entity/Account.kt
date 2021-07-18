package com.micronaut.study.entity

import java.math.BigDecimal
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "account")
class Account {

    @Id
    var id: UUID? = null

    @Column(name = "account_number")
    var accountNumber: Int = 0

    @Column(name = "balance")
    lateinit var balance: BigDecimal
}