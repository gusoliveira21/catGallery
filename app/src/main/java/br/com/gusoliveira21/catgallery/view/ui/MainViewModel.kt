package br.com.gusoliveira21.catgallery.view.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

abstract class MainViewModel : ViewModel() {

    abstract val catList: LiveData<MutableList<String>>

    abstract val error: LiveData<String>

    abstract fun getCatList(wordToSearch:String = "cat")

}