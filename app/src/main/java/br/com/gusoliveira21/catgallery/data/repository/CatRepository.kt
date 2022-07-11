package br.com.gusoliveira21.catgallery.data.repository

import br.com.gusoliveira21.catgallery.data.model.modelResultRetrofit.CatDataClass

interface CatRepository {
    suspend fun getData(): CatDataClass
}