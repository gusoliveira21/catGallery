package br.com.gusoliveira21.catgallery.view.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.gusoliveira21.catgallery.R
import org.koin.core.context.startKoin

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        startKoin{

        }
        Thread.sleep(1000)
        setTheme(R.style.Theme_CatGallery)
    }
}