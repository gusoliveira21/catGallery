package br.com.gusoliveira21.catgallery.application

import android.app.Application
import br.com.gusoliveira21.catgallery.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CatApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidLogger()
            androidContext(this@CatApplication)
            modules(mainModule)
        }
    }
}