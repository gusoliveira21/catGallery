package br.com.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInicializer {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.imgur.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getRetrofitService(): CatService = retrofit.create(CatService::class.java)
}