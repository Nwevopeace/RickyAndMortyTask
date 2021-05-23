package com.peacecodes.rickyandmockytask

import com.peacecodes.rickyandmockytask.Characters
import retrofit2.Call
import retrofit2.http.GET

private const val BASE_URL = "https://rickandmortyapi.com/"

interface ApiService {

    @GET("/api/character")
    fun getAllCharacters(): Call<ResponseData>
}