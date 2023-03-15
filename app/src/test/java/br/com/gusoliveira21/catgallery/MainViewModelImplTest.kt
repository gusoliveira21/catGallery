package br.com.gusoliveira21.catgallery

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import br.com.domain.entities.CatEntity
import br.com.domain.usercase.GetCatImagesUseCase
import br.com.domain.usercase.base.DataResult
import br.com.gusoliveira21.catgallery.view.router.RouterMainFragToFullscreenFrag
import br.com.gusoliveira21.catgallery.view.ui.mainFragment.MainViewModelImpl
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelImplTest {

    private var viewModel: MainViewModelImpl? = null
    private val getCatImagesUseCase: GetCatImagesUseCase = mockk(relaxed = true)
    private val routerMainFragToFullscreenFrag: RouterMainFragToFullscreenFrag =
        mockk(relaxed = true)

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        Dispatchers.setMain(TestCoroutineDispatcher())
        viewModel = MainViewModelImpl(getCatImagesUseCase, routerMainFragToFullscreenFrag)
    }

    @Test
    fun `when a valid search term is provided, should update the cat list`() {
        val searchWord = "kitten"
        val catEntity = CatEntity(image = "https://www.example.com/cat.jpg", "jpg")
        val catList = listOf(catEntity)
        val expectedList = mutableListOf(catEntity.image)

        coEvery { getCatImagesUseCase.execute(searchWord) } returns DataResult.Success(catList)

        viewModel?.getCatList(searchWord)

        assertEquals(expectedList, viewModel?.catList?.value)
    }

    @Test
    fun `when an invalid search term is provided, should emit an error message`() {
        val searchWord = ""
        val expectedErrorMessage = "Não foi possível obter a lista de gatos!!"

        viewModel?.getCatList(searchWord)

        assertEquals(expectedErrorMessage, viewModel?.error?.value)
    }

}