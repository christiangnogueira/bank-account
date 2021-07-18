package com.micronaut.study.endpoint

import com.micronaut.study.AccountTransferRequest
import com.micronaut.study.AccountTransferResponse
import com.micronaut.study.BankAccountServiceGrpcKt
import com.micronaut.study.useCase.TransferUserCase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TransferEndpoint : BankAccountServiceGrpcKt.BankAccountServiceCoroutineImplBase() {

    @Inject
    lateinit var transferUseCase: TransferUserCase

    override suspend fun transfer(request: AccountTransferRequest): AccountTransferResponse {
        return transferUseCase.transfer(request)
    }
}