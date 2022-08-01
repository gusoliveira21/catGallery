package br.com.domain.repository

import br.com.domain.entities.CatEntity

interface CatRepository {
    suspend fun getCats(): List<CatEntity>
}