package br.com.gusoliveira21.catgallery.domain.usercase

import android.os.Bundle
import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import assertk.assertThat
import assertk.assertions.isEqualTo
import br.com.gusoliveira21.catgallery.MainCoroutineRule
import br.com.gusoliveira21.catgallery.data.repository.CatRepository
import br.com.gusoliveira21.catgallery.domain.entities.CatEntity
import br.com.gusoliveira21.catgallery.extension.getOrAwaitValue
import br.com.gusoliveira21.catgallery.view.ui.MainViewModel
import br.com.gusoliveira21.catgallery.view.ui.MainViewModelUnitTest
import br.com.gusoliveira21.catgallery.view.ui.catDataMocked
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class GetCatImagesUseCaseTest : TestCase(){
    @get:Rule
    val rule = InstantTaskExecutorRule()
    @get:Rule
    var coroutinesTestRule = MainCoroutineRule()
    private val repository = mockk<CatRepository>(relaxed = true)

    private val testDispatcher = TestCoroutineDispatcher()
    private val testScope = TestCoroutineScope(testDispatcher)

    @Test
    fun `checks if the function return is a link`() {
        testScope.launch {
            // arrange
            coEvery { repository.getData() } returns catDataMocked
            val getCatImagesUseCaseTest = GetCatImagesUseCase(repository)
            // act
            val result = getCatImagesUseCaseTest.execute(Unit)
            // assert
            assertThat(result.success.data.first().image).isEqualTo("//i.imgur.com/8GkvlbT.jpgg")
        }
    }


}