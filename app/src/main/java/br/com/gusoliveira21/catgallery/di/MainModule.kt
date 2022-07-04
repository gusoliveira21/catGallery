package br.com.gusoliveira21.catgallery.di

import br.com.gusoliveira21.catgallery.api.CatService
import br.com.gusoliveira21.catgallery.api.RetrofitInicializer
import br.com.gusoliveira21.catgallery.data.repository.CatRepository
import br.com.gusoliveira21.catgallery.data.repository.CatRepositoryImpl
import br.com.gusoliveira21.catgallery.view.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    single<CatService> {
        RetrofitInicializer().getRetrofitService()
    }

    single<CatRepository> {
        CatRepositoryImpl(get())
    }

    viewModel { (catName: String) ->
        MainViewModel(get())
    }
}

