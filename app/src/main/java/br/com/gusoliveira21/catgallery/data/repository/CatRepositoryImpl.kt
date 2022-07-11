package br.com.gusoliveira21.catgallery.data.repository

import br.com.gusoliveira21.catgallery.data.api.CatService
import br.com.gusoliveira21.catgallery.data.model.modelResultRetrofit.CatDataClass

class CatRepositoryImpl(private val catService: CatService): CatRepository {
    override suspend fun getData(): CatDataClass {
        return catService.catList()
    }
}