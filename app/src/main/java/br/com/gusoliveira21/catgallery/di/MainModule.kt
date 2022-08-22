package br.com.gusoliveira21.catgallery.di

import br.com.domain.repository.CatRepository
import br.com.domain.usercase.GetCatImagesUseCase
import br.com.data.api.CatService
import br.com.data.api.RetrofitInicializer
import br.com.data.repository.CatRepositoryImpl
import br.com.gusoliveira21.catgallery.view.ui.MainViewModel
import br.com.gusoliveira21.catgallery.view.ui.MainViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    single<CatService> {
        RetrofitInicializer().getRetrofitService()
    }

    single<CatRepository> {
        CatRepositoryImpl(get(), get())
    }

    factory {
       GetCatImagesUseCase(get())
    }

    viewModel<MainViewModel> {
        MainViewModelImpl(get())
    }
}

