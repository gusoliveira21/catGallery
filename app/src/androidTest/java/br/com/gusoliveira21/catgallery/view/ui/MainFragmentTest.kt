package br.com.gusoliveira21.catgallery.view.ui

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import br.com.domain.repository.CatRepository
import br.com.domain.usercase.GetCatImagesUseCase
import io.mockk.mockk
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext.loadKoinModules
import org.koin.core.context.GlobalContext.unloadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.test.KoinTest

@RunWith(AndroidJUnit4ClassRunner::class)
class MainFragmentTest : KoinTest {

    private val repository = mockk<CatRepository>(relaxed = true)

    lateinit var mockedModule: Module

    @Before
    fun setup() {
        mockedModule = module {
            viewModel<MainViewModel> { MainViewModelImpl(GetCatImagesUseCase(repository)) }
        }

        loadKoinModules(mockedModule)
    }

    @After
    fun tearDown() {
        unloadKoinModules(mockedModule)
    }

    @Test
    fun giveWithoutConnectionThenShowConnectionErrorText() {
        val scenario = launchFragmentInContainer<MainFragment>()
    }
}