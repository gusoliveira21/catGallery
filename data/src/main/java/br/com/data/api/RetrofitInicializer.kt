package br.com.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInicializer {
    companion object {
        private const val BASE_URL = "https://api.imgur.com/"
    }
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getRetrofitService(): CatService = retrofit.create(CatService::class.java)


}