package br.com.gusoliveira21.catgallery.view.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import assertk.assertThat
import assertk.assertions.isEqualTo
import br.com.gusoliveira21.catgallery.MainCoroutineRule
import br.com.gusoliveira21.catgallery.data.repository.CatRepository
import br.com.gusoliveira21.catgallery.domain.usercase.GetCatImagesUseCase
import br.com.gusoliveira21.catgallery.extension.getOrAwaitValue
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description

//@RunWith é necessário apenas se você usar uma combinação de JUnit3 e JUnit4.
class MainViewModelUnitTest{

    @get:Rule
    val rule = InstantTaskExecutorRule()
    @get:Rule
    var coroutinesTestRule = MainCoroutineRule()
    private val repository = mockk<CatRepository>(relaxed = true)


    @Test
    fun `quando a ViewModel busca os dados ela deve chamar o repositorio`() {
        // arrange
        coEvery { repository.getData() } returns catDataMocked
        val viewModel = MainViewModel(GetCatImagesUseCase(repository))

        // act
        viewModel.getListRetrofit()

        // assert
        coVerify { repository.getData() }
    }

    @Test
    fun `dado que o viewModel foi iniciado quando eu chamar o metodo para obter os dados entao a lista de gatos e retornada com sucesso`() {
        // arrange
        coEvery { repository.getData() } returns catDataMocked
        val viewModel = MainViewModel(GetCatImagesUseCase(repository))

        // act
        viewModel.getListRetrofit()

        // assert
        val value = viewModel.catUriList.getOrAwaitValue()
        assertThat(value).isEqualTo(catDataExpected)
    }
}