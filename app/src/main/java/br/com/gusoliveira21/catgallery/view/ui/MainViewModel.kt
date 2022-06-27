package br.com.gusoliveira21.catgallery.view.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.gusoliveira21.catgallery.data.repository.CatRepository
import br.com.gusoliveira21.catgallery.model.modelResultRetrofit.CatDataClass
import kotlinx.coroutines.launch

class MainViewModel(private val catRepository: CatRepository) : ViewModel() {

    private var _catUriList = MutableLiveData<MutableList<String>>()
    val catUriList: LiveData<MutableList<String>>
        get() = _catUriList

    init {
        getListRetrofit()
    }

    fun getListRetrofit() {
        try {
            viewModelScope.launch {
                val listData = catRepository.getData()
                Log.e("teste", "${listData}")
                getListImg(listData)
            }
        } catch (e: Exception) {
            Log.e("Erro getListRetrofit()", "-> $e")
        }
    }

    private fun getListImg(listData: CatDataClass) {
        val listUriCat: MutableList<String> = mutableListOf()
        listData.data.forEach { dataList ->
            if (dataList.images != null) {
                dataList.images.forEach { imageList ->
                    if (imageList.type != "video/mp4" || imageList.type != "image/gif") {
                        listUriCat.add(imageList.link)
                    }
                }
            }
        }
        _catUriList.value = listUriCat
    }
}