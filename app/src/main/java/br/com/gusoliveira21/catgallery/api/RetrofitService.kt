package br.com.gusoliveira21.catgallery.api



import br.com.gusoliveira21.catgallery.model.CatDataClass
import br.com.gusoliveira21.catgallery.model.Data
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface RetrofitService {
    companion object{
        const val BASE_URL = "3/gallery/search/?q=cats"
        const val CLIENT_ID = "Authorization:  Client-ID 1ceddedc03a5d71"
    }
    @Headers(CLIENT_ID)
    @GET(BASE_URL)
    suspend fun catList(): CatDataClass

}
