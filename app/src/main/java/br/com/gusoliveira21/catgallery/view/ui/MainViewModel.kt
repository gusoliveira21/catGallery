package br.com.gusoliveira21.catgallery.view.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.gusoliveira21.catgallery.api.RetrofitInicializer
import br.com.gusoliveira21.catgallery.model.CatDataClass
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private var _catUriList = MutableLiveData<MutableList<String>>()
    val catUriList: LiveData<MutableList<String>>
        get() = _catUriList

    init {
        getListRetrofit()
    }

    private fun getListRetrofit() {
        viewModelScope.launch {
            coroutineScope {
                try {
                    val listData = async { RetrofitInicializer().getRetrofitService().catList() }
                    getListImg(listData.await())

                } catch (e: Exception) {
                    Log.e("Erro coroutine", "-> $e")
                }

            }
        }
    }

    private fun getListImg(listData: CatDataClass) {
        var listUriCat: MutableList<String> = mutableListOf()
        listData.data.forEach { dataList ->
            if (dataList.images != null) {
                dataList.images.forEach { imageList ->
                    if (imageList.type != "video/mp4" || imageList.type != "image/gif") {
                        listUriCat?.add(imageList.link)
                    }
                }
            }
        }
        _catUriList.value = listUriCat
    }
}