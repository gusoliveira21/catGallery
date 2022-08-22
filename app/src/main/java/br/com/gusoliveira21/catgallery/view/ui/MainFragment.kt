package br.com.gusoliveira21.catgallery.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import br.com.gusoliveira21.catgallery.databinding.MainFragmentBinding
import br.com.gusoliveira21.catgallery.view.adapter.MainFragmentAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModel()

    private val binding by lazy { MainFragmentBinding.inflate(LayoutInflater.from(requireContext())) }
    private var adapter = MainFragmentAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?,
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
    }

    private fun setupObservers() {
        //viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]
        viewModel.catList.observe(viewLifecycleOwner, Observer(::adapter))
        viewModel.error.observe(viewLifecycleOwner, Observer(::showError))
    }

    private fun adapter(catUriList: MutableList<String>) {
        adapter.catUriList = catUriList
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 4)
        binding.recyclerView.adapter = adapter
    }

    private fun showError(message: String)  {
        binding.textAviso.visibility = View.VISIBLE
        Toast.makeText(requireContext(),message, Toast.LENGTH_SHORT).show()
    }

//TODO: Exibir imagem selecionada em tela grande
//TODO: Caso nao tenha internet, exibir mensagem, esperar 3 segundos e fechar o app
//TODO: Durante a contagem dos tres segundos, o valor deve ser exibido na tela
}