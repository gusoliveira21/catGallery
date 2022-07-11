package br.com.gusoliveira21.catgallery.di

import br.com.gusoliveira21.catgallery.data.api.CatService
import br.com.gusoliveira21.catgallery.data.api.RetrofitInicializer
import br.com.gusoliveira21.catgallery.data.repository.CatRepository
import br.com.gusoliveira21.catgallery.data.repository.CatRepositoryImpl
import br.com.gusoliveira21.catgallery.domain.usercase.GetCatImagesUseCase
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

    factory {
       GetCatImagesUseCase(get())
    }

    viewModel {
        MainViewModel(get())
    }
}

