package com.emdasoft.myrates.data

import com.emdasoft.myrates.domain.models.Rates
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("rates")
    suspend fun getRates(): Response<Rates>

}