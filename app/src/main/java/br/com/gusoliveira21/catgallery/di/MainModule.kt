package br.com.gusoliveira21.catgallery.di

import androidx.navigation.NavController
import br.com.data.api.CatService
import br.com.data.api.RetrofitInicializer
import br.com.data.repository.CatRepositoryImpl
import br.com.domain.repository.CatRepository
import br.com.domain.usercase.GetCatImagesUseCase
import br.com.gusoliveira21.catgallery.view.router.RouterFragment
import br.com.gusoliveira21.catgallery.view.ui.fullscreenImageFragment.FullscreenImageFragmentArgs
import br.com.gusoliveira21.catgallery.view.ui.fullscreenImageFragment.FullscreenImageViewModel
import br.com.gusoliveira21.catgallery.view.ui.fullscreenImageFragment.FullscreenImageViewModelImpl
import br.com.gusoliveira21.catgallery.view.ui.mainFragment.MainViewModel
import br.com.gusoliveira21.catgallery.view.ui.mainFragment.MainViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

val mainModule = module {
    single<CatService> { RetrofitInicializer().getRetrofitService() }

    single<CatRepository> { CatRepositoryImpl(get(), get()) }

    factory { GetCatImagesUseCase(get()) }

    factory { (navController: NavController) -> RouterFragment(navController) }

    viewModel<MainViewModel> { (navController: NavController) ->
        MainViewModelImpl(
            get(),
            get { parametersOf(navController) }
        )
    }

    viewModel<FullscreenImageViewModel> { (args: FullscreenImageFragmentArgs) ->
        FullscreenImageViewModelImpl(
            args
        )
    }
}

