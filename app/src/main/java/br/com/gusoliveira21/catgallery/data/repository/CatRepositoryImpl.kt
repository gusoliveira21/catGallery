package br.com.gusoliveira21.catgallery.data.repository

import br.com.gusoliveira21.catgallery.api.CatService
import br.com.gusoliveira21.catgallery.model.modelResultRetrofit.CatDataClass

class CatRepositoryImpl(private val catService: CatService): CatRepository {
    override suspend fun getData(): CatDataClass {
        return catService.catList()
    }
}