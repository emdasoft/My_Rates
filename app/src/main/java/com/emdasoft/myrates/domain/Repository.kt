package com.emdasoft.myrates.domain

import com.emdasoft.myrates.domain.models.Rates
import retrofit2.Response

interface Repository {

    suspend fun getRates(): Response<Rates>

}