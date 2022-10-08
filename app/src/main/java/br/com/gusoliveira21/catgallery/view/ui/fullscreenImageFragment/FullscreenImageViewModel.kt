package br.com.gusoliveira21.catgallery.view.ui.fullscreenImageFragment

import android.content.Context
import android.widget.ImageView
import androidx.lifecycle.ViewModel
import com.google.android.material.card.MaterialCardView

abstract class FullscreenImageViewModel: ViewModel() {
    abstract fun setFullscreenImage(applicationContext: Context, imageSource: ImageView)
    abstract fun setFullscreenImageWithPalletColor(context: Context, viewImagem: ImageView, cardView: MaterialCardView)
}