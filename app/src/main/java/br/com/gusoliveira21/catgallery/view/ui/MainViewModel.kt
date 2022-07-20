package br.com.gusoliveira21.catgallery.view.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.gusoliveira21.catgallery.domain.entities.CatEntity
import br.com.gusoliveira21.catgallery.domain.usercase.GetCatImagesUseCase
import kotlinx.coroutines.launch

class MainViewModel(private val getCatImagesUseCase: GetCatImagesUseCase) : ViewModel() {

    private var _catUriList = MutableLiveData<MutableList<String>>()
    val catUriList: LiveData<MutableList<String>>
        get() = _catUriList

    init {
        getListRetrofit()
    }

    fun getListRetrofit() {
        viewModelScope.launch {
            val result = getCatImagesUseCase.execute(Unit)
            result.handleResult(::getCatListSuccess, ::getCatListFailure)
        }
    }

    private fun getCatListSuccess(list: List<CatEntity>) {
        _catUriList.value = list.map { it.image }.toMutableList()
    }

    private fun getCatListFailure() {
        // Retornar algum erro para  tela
    }
}