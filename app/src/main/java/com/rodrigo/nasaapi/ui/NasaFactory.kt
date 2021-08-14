package com.rodrigo.nasaapi.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rodrigo.nasaapi.repository.NasaRepository
import java.lang.Exception

class NasaFactory(private val repository: NasaRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NasaViewModel::class.java)){
            return NasaViewModel(repository) as T
        }
        throw Exception ("Unknown ViewModel Class")
    }
}