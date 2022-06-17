package br.com.gusoliveira21.catgallery.view.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import br.com.gusoliveira21.catgallery.data.MockData
import br.com.gusoliveira21.catgallery.data.Repository
import br.com.gusoliveira21.catgallery.model.modelResultRetrofit.CatDataClass
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Rule
import org.junit.Test

//@RunWith é necessário apenas se você usar uma combinação de JUnit3 e JUnit4.
class MainViewModelUnitTest{
    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val repository = mockk<Repository>()
    private val onDataLoadedObserver = mockk<Observer<List<CatDataClass>>>(relaxed = true)
    @Test
    fun `quando a ViewModel busca os dados ela deve chamar o repositorio`() {
        val viewModel = instantiateViewModel()
        val mockedData = MockData().getMockData()
        //Toda chamada para repository.getData() vai retornar mockedData
        every { repository.getData() } returns mockedData
        viewModel.getListRetrofit()
        //Verifica se a função getData() foi chamada
        verify { repository.getData() }
        //Verifica se o observer foi acionado
        //verify { onDataLoadedObserver.onChanged(listOf(mockedData)) }
    }

    private fun instantiateViewModel(): MainViewModel {
        val viewModel = MainViewModel(repository)
        viewModel.catUriList.observeForever(Observer{onDataLoadedObserver})
        return viewModel
    }
}