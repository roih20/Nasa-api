package com.rodrigo.nasaapi

import android.app.Application
import com.rodrigo.nasaapi.api.NasaApi
import com.rodrigo.nasaapi.repository.NasaRepository

class NasaApplication: Application() {

    val repository by lazy {
        NasaRepository(NasaApi)
    }
}