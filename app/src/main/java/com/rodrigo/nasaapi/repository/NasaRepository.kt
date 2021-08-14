package com.rodrigo.nasaapi.repository

import com.rodrigo.nasaapi.api.ApiService
import com.rodrigo.nasaapi.api.Apod
import com.rodrigo.nasaapi.api.NasaApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class NasaRepository(private val api: NasaApi){

    suspend fun getApod(): Response<Apod> {
        return withContext(Dispatchers.IO){
            api.service.getApod()
        }
    }
}