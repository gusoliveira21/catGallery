package br.com.gusoliveira21.catgallery.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import br.com.gusoliveira21.catgallery.databinding.MainFragmentBinding
import br.com.data.util.Util.statusInternet
import br.com.gusoliveira21.catgallery.view.adapter.MainFragmentAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.dsl.module

val mainFragmentModule = module{
    factory { MainFragment() }
}

class MainFragment : Fragment() {

    //private lateinit var viewModel: MainViewModel
    private val viewModel: MainViewModel by viewModel()

    private val binding by lazy { MainFragmentBinding.inflate(LayoutInflater.from(requireContext())) }
    private var adapter = MainFragmentAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?,
    ): View {
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //TODO: Retirar lógica da view
        if(statusInternet(requireContext())) {
            setupObservers()
        }else {
            binding.textAviso.visibility = View.VISIBLE
        }
    }

    private fun setupObservers(){
        //viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]
        viewModel.catUriList.observe(viewLifecycleOwner, Observer(::adapter))
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