package br.com.gusoliveira21.catgallery.view.ui.fullscreenImageFragment

import android.content.Context
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Handler
import android.os.Looper
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.palette.graphics.Palette
import br.com.gusoliveira21.catgallery.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import jp.wasabeef.glide.transformations.CropSquareTransformation

class FullscreenImageViewModelImpl( private val args: FullscreenImageFragmentArgs )
    : FullscreenImageViewModel() {

    override fun setFullscreenImage(applicationContext: Context, imageSource: ImageView) {
        Glide
            .with(applicationContext)
            .load(args.link)
            .apply(RequestOptions.bitmapTransform(CropSquareTransformation()))
            .into(imageSource)
    }

    override fun setFullscreenImageWithPalletColor(
        context: Context,
        viewImagem: ImageView,
        cardView: FrameLayout
    ) {
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

                    //TODO: Se estiver no modo escuro não se deve ativar o Pallet, deve-se ativar uma cor escura padrão
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
                                cardView.setBackgroundColor(cor)
                            }
                        }
                        return false
                    }
                })
                .into(viewImagem)
        }
    }
}