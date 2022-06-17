package br.com.gusoliveira21.catgallery.view.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.gusoliveira21.catgallery.data.Repository
import br.com.gusoliveira21.catgallery.data.RepositoryImpl
import br.com.gusoliveira21.catgallery.model.modelResultRetrofit.CatDataClass

class MainViewModel(private val repository: Repository) : ViewModel() {

    private var _catUriList = MutableLiveData<MutableList<String>>()
    val catUriList: LiveData<MutableList<String>>
        get() = _catUriList

    init {
        getListRetrofit()
    }

    fun getListRetrofit() {
        try {
            val listData =  repository.getData()
            Log.e("teste","${listData}")
            /*getListImg(listData)*/
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

    //TODO: Relembrar para que serve exatamente.
    @Suppress("UNCHECKED_CAST")
    class Factory: ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainViewModel(RepositoryImpl()) as T
        }
    }


}