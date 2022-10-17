package com.emdasoft.myrates.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emdasoft.myrates.data.RepositoryImpl
import com.emdasoft.myrates.domain.GetRatesUseCase
import com.emdasoft.myrates.domain.models.Rates
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel: ViewModel() {

    private val repository = RepositoryImpl
    private val getRatesUseCase = GetRatesUseCase(repository)

    val ratesList: MutableLiveData<Response<Rates>> = MutableLiveData()

    fun getRates() {
        viewModelScope.launch {
            ratesList.postValue(getRatesUseCase.getRates())
//            process.showProgress(false)
        }
    }


}