package br.com.gusoliveira21.catgallery.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
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

        return binding.root}

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if(statusInternet(requireContext())) {
            viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
            binding.lifecycleOwner = viewLifecycleOwner
            viewModel.catUriList.observe(viewLifecycleOwner, Observer {
                adapter(it)
            })
        }else{
            Toast.makeText(requireContext(),"Sem conexão com a internet!", Toast.LENGTH_LONG).show()
        }
    }

    private fun adapter(catUriList: MutableList<String>) {
        adapter.catUriList = catUriList
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 4)
        binding.recyclerView.adapter = adapter
    }

}
//TODO:Verificar autorização
//TODO:Verificar internet