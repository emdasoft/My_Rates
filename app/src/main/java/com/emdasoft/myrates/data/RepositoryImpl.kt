package com.emdasoft.myrates.data

import com.emdasoft.myrates.domain.Repository
import com.emdasoft.myrates.domain.models.Rates
import retrofit2.Response

object RepositoryImpl : Repository {

    override suspend fun getRates(): Response<Rates> {

        return RetrofitInstance.apiService.getRates()

    }

}