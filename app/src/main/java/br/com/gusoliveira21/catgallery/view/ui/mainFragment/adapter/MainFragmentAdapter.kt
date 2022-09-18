package br.com.gusoliveira21.catgallery.view.ui.mainFragment.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import br.com.gusoliveira21.catgallery.databinding.ItemImgRecyclerBinding

//TODO: Salvar imagens recuperadas no Room e realizar o consumo do Adapter a partir dele
class MainFragmentAdapter(
    private val onClickItem: (String) -> Unit
): ListAdapter<br.com.data.modelResultRetrofit.Image, ViewHolder>(
    DiffCallBack()
) {
    var catUriList: MutableList<String> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val bindingRecyclerView = ItemImgRecyclerBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(bindingRecyclerView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.putImagem(catUriList[position])
        holder.imageClicked(catUriList[position], onClickItem)
    }

    override fun getItemCount() = catUriList.size

    /*class ViewHolder(itemView: ItemImgRecyclerBinding) : RecyclerView.ViewHolder(itemView.root) {
        private val viewImagem = itemView.imageCat

        fun imageClicked(link: String){
            viewImagem.setOnClickListener {
                Log.e("tag",link)
            }
        }
        fun putImagem(link: String) {
            Glide
                .with(itemView.rootView.context)
                .load(link)
                .apply(RequestOptions.bitmapTransform(CropSquareTransformation()))
                .into(viewImagem)
        }
    }*/
}

class DiffCallBack : DiffUtil.ItemCallback<br.com.data.modelResultRetrofit.Image>() {
    override fun areItemsTheSame(oldItem: br.com.data.modelResultRetrofit.Image, newItem: br.com.data.modelResultRetrofit.Image) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: br.com.data.modelResultRetrofit.Image, newItem: br.com.data.modelResultRetrofit.Image) = oldItem == newItem
}


