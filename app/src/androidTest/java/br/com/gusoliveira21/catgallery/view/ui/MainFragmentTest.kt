package br.com.gusoliveira21.catgallery.view.ui

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import br.com.domain.exceptions.NoConnection
import br.com.domain.repository.CatRepository
import br.com.domain.usercase.GetCatImagesUseCase
import br.com.gusoliveira21.catgallery.view.ui.robot.MainRobot
import com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import io.mockk.coEvery
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
        // arrange
        coEvery { repository.getCats("cat") } throws NoConnection()

        // action
        launchFragmentInContainer<MainFragment>()

        // assert
        onView(withText("Sem sinal de internet!")).check(matches(isDisplayed()))
    }

    @Test
    fun giveWithoutConnectionThenShowConnectionErrorText_withBaristaDependency() {
        //Reference: https://github.com/AdevintaSpain/Barista

        // arrange
        coEvery { repository.getCats("cat") } throws NoConnection()

        // action
        launchFragmentInContainer<MainFragment>()

        // assert
        assertDisplayed("Sem sinal de internet!")
    }
    //TODO: 
    /*@Test
    fun giveWithoutConnectionThenShowConnectionErrorText_withRobotPattern() {
        // arrange
        coEvery { repository.getCats("cat") } throws NoConnection()

        MainRobot()
            .startScreen()
            .verifyNoConnectionDisplayed()
    }*/
}