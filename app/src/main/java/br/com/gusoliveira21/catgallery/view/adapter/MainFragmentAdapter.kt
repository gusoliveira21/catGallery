package br.com.gusoliveira21.catgallery.view.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.gusoliveira21.catgallery.databinding.ItemImgRecyclerBinding
import br.com.data.modelResultRetrofit.Image
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import jp.wasabeef.glide.transformations.CropSquareTransformation
//TODO: Adicionar exibição da imagem em tela grande
//TODO: Salvar imagens recuperadas no Room e realizar o consumo do Adapter a partir dele
class MainFragmentAdapter : ListAdapter<br.com.data.modelResultRetrofit.Image, MainFragmentAdapter.ViewHolder>(DiffCallBack()) {
    var catUriList: MutableList<String> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val bindingRecyclerView = ItemImgRecyclerBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(bindingRecyclerView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.putImagem(catUriList[position])
    }

    override fun getItemCount() = catUriList.size

    class ViewHolder(itemView: ItemImgRecyclerBinding) : RecyclerView.ViewHolder(itemView.root) {
        private val viewImagem = itemView.imageCat

        fun putImagem(link: String) {
            Glide
                .with(itemView.rootView.context)
                .load(link)
                .apply(RequestOptions.bitmapTransform(CropSquareTransformation()))
                .into(viewImagem)
        }

    }
}

class DiffCallBack : DiffUtil.ItemCallback<br.com.data.modelResultRetrofit.Image>() {
    override fun areItemsTheSame(oldItem: br.com.data.modelResultRetrofit.Image, newItem: br.com.data.modelResultRetrofit.Image) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: br.com.data.modelResultRetrofit.Image, newItem: br.com.data.modelResultRetrofit.Image) = oldItem == newItem
}


