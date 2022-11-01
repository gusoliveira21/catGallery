package br.com.data.api

import br.com.data.modelResultRetrofit.CatDataClass
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface CatService {
    //val RESOURCE_URL_ORIGINAL = "3/gallery/search/?q=cats"
    @Headers("Authorization:  Client-ID 1ceddedc03a5d71")
    @GET("3/gallery/search/")
    suspend fun catList(@Query("q") params: String): CatDataClass
}
