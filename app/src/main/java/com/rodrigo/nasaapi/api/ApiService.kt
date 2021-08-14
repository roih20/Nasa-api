package com.rodrigo.nasaapi.api

import retrofit2.Response
import retrofit2.http.GET


private const val DEMO_KEY ="cCpGHhadTsxTYXKzxAZB5WNUzJ4181y4QByo6YeJ"

interface ApiService {

    @GET("apod?api_key=$DEMO_KEY")
    suspend fun getApod(): Response<Apod>

}