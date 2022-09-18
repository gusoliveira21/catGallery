package br.com.gusoliveira21.catgallery.view.ui.mainFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.domain.entities.CatEntity
import br.com.domain.usercase.GetCatImagesUseCase
import br.com.gusoliveira21.catgallery.view.router.RouterFragment
import kotlinx.coroutines.launch

class MainViewModelImpl(
    private val getCatImagesUseCase: GetCatImagesUseCase,
    private val router: RouterFragment
    ) : MainViewModel() {

    override val catList = MutableLiveData<MutableList<String>>()

    override val error = MutableLiveData<String>()

    init {
        getCatList()
    }

    override fun getCatList(wordToSearch:String) {
        if(wordToSearch.isNotBlank() || wordToSearch.isNotEmpty()) {
            viewModelScope.launch {
                val result = getCatImagesUseCase.execute(wordToSearch)
                result.handleResult(::getCatListSuccess, ::getCatListFailure)
            }
        }
    }

    private fun getCatListSuccess(list: List<CatEntity>) {
        catList.value = list.map { it.image }.toMutableList()
    }

    private fun getCatListFailure() {
        error.value = "Não foi possível obter a lista de gatos!!"
    }
}