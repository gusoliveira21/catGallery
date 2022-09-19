package br.com.gusoliveira21.catgallery.view.ui.fullscreenImageFragment

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import jp.wasabeef.glide.transformations.CropSquareTransformation

class FullscreenImageViewModelImpl(
    private val args: FullscreenImageFragmentArgs
    ) :FullscreenImageViewModel(){

    override fun setFullscreenImage(applicationContext: Context, imageSource: ImageView) {
        Glide
            .with(applicationContext)
            .load(args.link)
            .apply(RequestOptions.bitmapTransform(CropSquareTransformation()))
            .into(imageSource)
    }
}