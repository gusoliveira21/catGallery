package br.com.data.api

import br.com.data.modelResultRetrofit.CatDataClass
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface CatService {
    companion object{
        const val RESOURCE_URL_ORIGINAL = "3/gallery/search/?q=cats"
        const val RESOURCE_URL = "3/gallery/search/"
        const val CLIENT_ID = "Authorization:  Client-ID 1ceddedc03a5d71"
    }
    @Headers(CLIENT_ID)
    @GET(RESOURCE_URL)
    suspend fun catList(@Query("q") params:String): CatDataClass

}
