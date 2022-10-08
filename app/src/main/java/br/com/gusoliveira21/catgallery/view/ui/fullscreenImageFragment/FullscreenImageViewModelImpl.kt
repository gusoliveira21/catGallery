package br.com.gusoliveira21.catgallery.view.ui.fullscreenImageFragment

import android.content.Context
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.palette.graphics.Palette
import androidx.core.content.ContextCompat
import br.com.gusoliveira21.catgallery.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.google.android.material.card.MaterialCardView
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

    override fun setFullscreenImageWithPalletColor(context: Context, viewImagem: ImageView, cardView: MaterialCardView){
        Handler(Looper.getMainLooper()).post {
            Glide.with(context)
                .load(args.link)
                .error(R.drawable.ic_broken_image_64)
                .apply(RequestOptions.bitmapTransform(CropSquareTransformation()))
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean,
                    ): Boolean {
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean,
                    ): Boolean {
                        var cor = 0
                        val drawable = resource as BitmapDrawable
                        val bitmap = drawable.bitmap

                        Palette.Builder(bitmap).generate {
                            it?.let { palette ->
                                cor = palette.getDominantColor(
                                    ContextCompat.getColor(
                                        context,
                                        R.color.white
                                    )
                                )
                                cardView.setCardBackgroundColor(cor)
                            }
                        }
                        return false
                    }
                })
                .into(viewImagem)
        }
    }
}