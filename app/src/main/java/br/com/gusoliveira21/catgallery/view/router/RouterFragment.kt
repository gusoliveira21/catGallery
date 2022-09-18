package br.com.gusoliveira21.catgallery.view.router

import androidx.navigation.NavController
import br.com.gusoliveira21.catgallery.R

class RouterFragment(private val navController: NavController) {
    fun mainFragmentToFullscreenImageFragment() {
        navController.navigate(R.id.action_mainFragment_to_fullscreenImageFragment);
    }
}