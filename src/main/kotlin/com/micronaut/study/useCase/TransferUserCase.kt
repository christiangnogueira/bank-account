package com.micronaut.study.useCase

import com.micronaut.study.AccountTransferRequest
import com.micronaut.study.AccountTransferResponse
import com.micronaut.study.entity.Account
import com.micronaut.study.repository.AccountRepository
import com.micronaut.study.repository.AccountRepositoryImpl
import java.math.BigDecimal
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TransferUserCase {

    @Inject
    lateinit var accountRepository: AccountRepositoryImpl

    fun transfer(request: AccountTransferRequest): AccountTransferResponse {
        try {
            var account: Account = accountRepository.getByAccountNumber(request.destinationAccount)
            account.id?.let { accountRepository.updateBalance(it, BigDecimal.valueOf(request.value)) }
        } catch (ex: Exception) {
            return AccountTransferResponse
                .newBuilder()
                .setMessage("Deu ruim " + ex.message)
                .build()
        }


        return AccountTransferResponse
            .newBuilder()
            .setMessage("Atualizado com sucesso!")
            .build()
    }
}