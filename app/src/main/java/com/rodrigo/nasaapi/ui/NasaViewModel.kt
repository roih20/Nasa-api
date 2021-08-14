package com.rodrigo.nasaapi.ui

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodrigo.nasaapi.api.Apod
import com.rodrigo.nasaapi.repository.NasaRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Response

class NasaViewModel(private val repository: NasaRepository): ViewModel() {

    private var _loading = MutableLiveData(View.GONE)
    val loading: LiveData<Int?> get() = _loading
    var apod = MutableLiveData<Response<Apod>>()

    fun getApod(){
        _loading.value = View.VISIBLE
        viewModelScope.launch {
                try {
                    val response = repository.getApod()
                    apod.value = response
                }catch (e: HttpException){

                }finally {
                    _loading.value = View.GONE
                }
        }
    }

}