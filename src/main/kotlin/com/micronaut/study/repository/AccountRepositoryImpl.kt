package com.micronaut.study.repository

import com.micronaut.study.entity.Account
import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession
import io.micronaut.transaction.annotation.ReadOnly
import java.math.BigDecimal
import java.util.*
import javax.inject.Singleton
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.transaction.Transactional

@Singleton
open class AccountRepositoryImpl(@field:PersistenceContext val entityManager: EntityManager) : AccountRepository {

    @ReadOnly
    override fun getByAccountNumber(accountNumber: Int): Account {
        print("Teste")
        return entityManager
            .createQuery("SELECT a FROM Account as a WHERE a.accountNumber =:accountNumber")
            .setParameter("accountNumber", accountNumber)
            .singleResult as Account
    }

    @ReadOnly
    override fun updateBalance(id: UUID, balance: BigDecimal): Int {
        return entityManager
            .createQuery("UPDATE Account SET balance = :balance where id = :id")
            .setParameter("balance", balance)
            .setParameter("id", id)
            .executeUpdate()
    }
}