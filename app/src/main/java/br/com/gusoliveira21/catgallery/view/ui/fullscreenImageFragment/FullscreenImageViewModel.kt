package br.com.gusoliveira21.catgallery.view.ui.fullscreenImageFragment

import android.content.Context
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.lifecycle.ViewModel

abstract class FullscreenImageViewModel: ViewModel() {
    abstract fun setFullscreenImage(applicationContext: Context, imageSource: ImageView)
    abstract fun setFullscreenImageWithPalletColor(context: Context, viewImagem: ImageView, cardView: FrameLayout)
}