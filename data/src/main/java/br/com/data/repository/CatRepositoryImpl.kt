package br.com.data.repository

import android.content.Context
import br.com.data.api.CatService
import br.com.data.util.Util
import br.com.data.util.Util.toCatEntity
import br.com.domain.entities.CatEntity
import br.com.domain.exceptions.NoConnection
import br.com.domain.repository.CatRepository

class CatRepositoryImpl(private val catService: CatService, private val context: Context) :
    CatRepository {
    override suspend fun getCats(wordToSearch: String): List<CatEntity> {
        if (Util.statusInternet(context)) {
            val list: MutableList<CatEntity> = mutableListOf()
            catService.catList(wordToSearch).data.forEach { data ->
                data.images?.forEach { image ->
                    list.add(image.toCatEntity())
                }
            }
            return list
        } else {
            throw NoConnection()
        }
    }
}