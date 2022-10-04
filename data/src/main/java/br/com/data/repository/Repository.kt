package br.com.data.repository

import br.com.data.modelResultRetrofit.CatDataClass
import br.com.data.api.RetrofitInicializer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
//TODO: "Essa interface serve para alguma coisa?"
interface Repository {
    fun getData(): CatDataClass
}

/*
class RepositoryImpl: Repository {
    override fun getData(): CatDataClass {
        var data =
                runBlocking {
                    withContext(Dispatchers.IO) {
                       async { RetrofitInicializer().getRetrofitService().catList()}.await()
                }
            }
        return data
    }
}*/
