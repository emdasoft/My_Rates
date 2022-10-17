package com.emdasoft.myrates.domain

import com.emdasoft.myrates.domain.models.Rates
import retrofit2.Response

class GetRatesUseCase(private val repository: Repository) {

    suspend fun getRates(): Response<Rates> {

        return repository.getRates()

    }
}