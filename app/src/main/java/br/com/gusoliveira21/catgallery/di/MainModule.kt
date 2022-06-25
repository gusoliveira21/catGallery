package br.com.gusoliveira21.catgallery.di

import br.com.gusoliveira21.catgallery.data.repository.CatRepository
import br.com.gusoliveira21.catgallery.data.repository.CatRepositoryImpl
import br.com.gusoliveira21.catgallery.view.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    single<CatRepository>{ CatRepositoryImpl(get()) } //nao tenho certeza com relação a esse get()
    viewModel { MainViewModel(get()) }
}

/*
val mainModule = module {
    singleOf(::CatRepositoryImpl){bind<CatRepository>()}
    viewModelOf(::MainViewModel)
}*/
