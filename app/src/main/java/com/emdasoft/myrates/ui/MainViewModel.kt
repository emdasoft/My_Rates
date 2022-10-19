package com.emdasoft.myrates.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emdasoft.myrates.data.RepositoryImpl
import com.emdasoft.myrates.domain.GetRateListUseCase
import com.emdasoft.myrates.domain.models.Rates
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel : ViewModel() {

    private val repository = RepositoryImpl

    private val getRateListUseCase = GetRateListUseCase(repository)

    val rateList: MutableLiveData<Response<Rates>> = MutableLiveData()

    fun getRates() {
        viewModelScope.launch {
            rateList.postValue(getRateListUseCase.getRateList())
        }
    }
}