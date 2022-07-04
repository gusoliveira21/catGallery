package br.com.gusoliveira21.catgallery.data

import br.com.gusoliveira21.catgallery.api.RetrofitInicializer
import br.com.gusoliveira21.catgallery.model.modelResultRetrofit.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

interface Repository {
    fun getData(): CatDataClass
}

class RepositoryImpl:Repository{
    override fun getData(): CatDataClass {
        var data =
                runBlocking {
                    withContext(Dispatchers.IO) {
                       async {RetrofitInicializer().getRetrofitService().catList()}.await()
                }
            }
        return data
    }
}