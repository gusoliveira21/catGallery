package br.com.gusoliveira21.catgallery.view.router

import androidx.navigation.NavController
import br.com.gusoliveira21.catgallery.view.ui.mainFragment.MainFragmentDirections

class Router(private val navController: NavController) {
    fun mainFragmentToFullscreenImageFragment(link:String) {
        navController.navigate(MainFragmentDirections.actionMainFragmentToFullscreenImageFragment(link))
    }
}
