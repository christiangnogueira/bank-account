package com.micronaut.study.repository

import com.micronaut.study.entity.Account
import java.math.BigDecimal
import java.util.*

interface AccountRepository {

    fun getByAccountNumber(accountNumber: Int): Account
    fun updateBalance(id: UUID, balance: BigDecimal): Int
}