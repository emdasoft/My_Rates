package com.emdasoft.myrates.domain

import com.emdasoft.myrates.domain.models.Rates
import retrofit2.Response

class GetRateLIstUseCase(private val repository: Repository) {

    suspend fun getRateList(): Response<Rates> {
        return repository.getRateList()
    }
}