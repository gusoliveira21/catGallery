package br.com.gusoliveira21.catgallery.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import br.com.gusoliveira21.catgallery.databinding.MainFragmentBinding
import br.com.gusoliveira21.catgallery.util.Util.statusInternet
import br.com.gusoliveira21.catgallery.view.adapter.MainFragmentAdapter

class MainFragment : Fragment() {
    private val binding by lazy { MainFragmentBinding.inflate(LayoutInflater.from(requireContext())) }
    private lateinit var viewModel: MainViewModel
    private var adapter = MainFragmentAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?,
    ): View {
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if(statusInternet(requireContext())) {
            viewModel = ViewModelProvider(this)[MainViewModel::class.java]

            binding.lifecycleOwner = viewLifecycleOwner
            viewModel.catUriList.observe(viewLifecycleOwner, {
                adapter(it)
            })
        }else {
            binding.textAviso.visibility = View.VISIBLE
        }
    }

    private fun adapter(catUriList: MutableList<String>) {
        adapter.catUriList = catUriList
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 4)
        binding.recyclerView.adapter = adapter
    }
//TODO: Exibir imagem selecionada em tela grande
//TODO: Caso nao tenha internet, exibir mensagem, esperar 3 segundos e fechar o app
//TODO: Durante a contagem dos tres segundos, o valor deve ser exibido na tela
}