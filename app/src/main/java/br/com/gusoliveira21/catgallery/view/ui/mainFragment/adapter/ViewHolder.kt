package br.com.gusoliveira21.catgallery.view.ui.mainFragment.adapter

import androidx.recyclerview.widget.RecyclerView
import br.com.gusoliveira21.catgallery.databinding.ItemImgRecyclerBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import jp.wasabeef.glide.transformations.CropSquareTransformation

class ViewHolder(itemView: ItemImgRecyclerBinding) : RecyclerView.ViewHolder(itemView.root) {
    private val viewImagem = itemView.imageCat

    fun imageClicked(link:String, onClickItem: (String) -> Unit) {
        viewImagem.setOnClickListener { onClickItem(link) }
    }

    fun putImagem(link: String) {
        Glide
            .with(itemView.rootView.context)
            .load(link)
            .apply(RequestOptions.bitmapTransform(CropSquareTransformation()))
            .into(viewImagem)
    }
}