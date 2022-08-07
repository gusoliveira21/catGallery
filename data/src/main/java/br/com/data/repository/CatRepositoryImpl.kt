package br.com.data.repository

import br.com.domain.entities.CatEntity
import br.com.domain.repository.CatRepository
import br.com.data.api.CatService

class CatRepositoryImpl(private val catService: CatService): CatRepository {
    override suspend fun getCats(): List<CatEntity> {
        val list: MutableList<CatEntity> = mutableListOf()

        catService.catList().data.forEach { data ->
           data.images?.forEach { image ->
               list.add(CatEntity(
                   image = image.link,
                   type = image.type
               ))
           }
        }
        return list
    }
}