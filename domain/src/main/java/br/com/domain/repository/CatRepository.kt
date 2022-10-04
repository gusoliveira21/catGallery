package br.com.domain.repository

import br.com.domain.entities.CatEntity

interface CatRepository {
    suspend fun getCats(wordToSearch:String): List<CatEntity>
}
