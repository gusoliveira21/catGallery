/*
package br.com.gusoliveira21.catgallery.view.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.navigation.NavController
import androidx.navigation.NavViewModelStoreProvider
import androidx.test.core.app.ApplicationProvider
import br.com.domain.repository.CatRepository
import br.com.domain.usercase.GetCatImagesUseCase
import br.com.gusoliveira21.catgallery.MainCoroutineRule
import br.com.gusoliveira21.catgallery.catDataReality
import br.com.gusoliveira21.catgallery.view.router.RouterMainFragToFullscreenFrag
import br.com.gusoliveira21.catgallery.view.ui.mainFragment.MainFragmentDirections
import br.com.gusoliveira21.catgallery.view.ui.mainFragment.MainViewModel
import br.com.gusoliveira21.catgallery.view.ui.mainFragment.MainViewModelImpl
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext
import org.koin.core.context.GlobalContext.get
import org.koin.core.module.Module
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

//@RunWith é necessário apenas se você usar uma combinação de JUnit3 e JUnit4.
class MainViewModelUnitTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @get:Rule
    var coroutinesTestRule = MainCoroutineRule()
    private val repository = mockk<CatRepository>(relaxed = true)

    lateinit var mockedModule: Module
    //private val navController = TestNavHostController()
    //private val router = RouterMainFragToFullscreenFrag(navController)
    //private val navController = NavController(ApplicationProvider.getApplicationContext())
    //private val navController : NavViewModel

    @Before
    fun setup() {
        mockedModule = module {
            viewModel<MainViewModel> { (navController: NavController) ->
                MainViewModelImpl(
                    GetCatImagesUseCase(repository),
                    RouterMainFragToFullscreenFrag(
                        get { parametersOf(navController) }
                    )
                )
            }
            single { (navController: NavController) -> RouterMainFragToFullscreenFrag(navController) }
        }
        GlobalContext.loadKoinModules(mockedModule)
    }

    @After
    fun tearDown() {
        GlobalContext.unloadKoinModules(mockedModule)
    }


    //TODO: Corrigir erro no Router
    @Test
    fun `quando a ViewModel busca os dados ela deve chamar o repositorio`() {
        // arrange
        coEvery { repository.getCats("cats") } returns catDataReality
        val viewModel : MainViewModel<MainViewModelImpl>()

        // act
        viewModel.getCatList()

        // assert
        coVerify { repository.getCats("cats") }
    }

    //TODO: Corrigir teste
    @Test
    fun `dado que o viewModel foi iniciado, quando eu chamar o metodo para obter os dados entao a lista de gatos e retornada com sucesso`() {
        // arrange
        coEvery { repository.getCats("cats") } returns catDataReality
        val viewModel = MainViewModelImpl(
            GetCatImagesUseCase(repository),
            Router()
        )

        // act
        viewModel.getCatList()

        // assert
        val value = viewModel.catList.getOrAwaitValue()

        assertThat(value).isEqualTo(catDataExpected)
    }
}*/
