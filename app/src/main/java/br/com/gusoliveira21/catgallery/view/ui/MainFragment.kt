package br.com.gusoliveira21.catgallery.view.ui

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.GridLayoutManager
import br.com.gusoliveira21.catgallery.R
import br.com.gusoliveira21.catgallery.databinding.MainFragmentBinding
import br.com.gusoliveira21.catgallery.view.adapter.MainFragmentAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModel()

    private lateinit var binding : MainFragmentBinding

    private var adapter = MainFragmentAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?,
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
        var search: MenuItem = menu.findItem(R.id.bar_search)
        var editSearch: SearchView = search.actionView as SearchView
        editSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                //Se houver click mas o campo estiver vazio, exiba uma mensagem de aviso.
                viewModel.getCatList(p0!!)
                editSearch.clearFocus()
                return false
            }
            override fun onQueryTextChange(p0: String?): Boolean {
                Log.e("teste", "Modando!")
                return false
            }
        }
        )
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        listener()
    }

    private fun setupObservers() {
        //viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]
        viewModel.catList.observe(viewLifecycleOwner, Observer(::adapter))
        viewModel.error.observe(viewLifecycleOwner, Observer(::showError))
    }

    fun listener(){
//        binding.apply {
//            searchButton.setOnClickListener {
//                viewModel.getCatList(binding.searchFieldId.text.toString())
//                hideKeyBoard(requireActivity(), binding.searchInput)
//                searchFieldId.text?.clear()
//                searchInput.clearFocus()
//            }
//        }

    }

    private fun showResearchField() {
//        binding.searchButton.visibility = View.VISIBLE
//        binding.searchInput.visibility = View.VISIBLE
    }

    private fun adapter(catUriList: MutableList<String>) {
        adapter.catUriList = catUriList
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 4)
        binding.recyclerView.adapter = adapter
        showResearchField()
    }

    private fun showError(message: String)  {
        binding.textAviso.visibility = View.VISIBLE
        Toast.makeText(requireContext(),message, Toast.LENGTH_SHORT).show()
    }

//TODO: Exibir imagem selecionada em tela grande
//TODO: Caso nao tenha internet, exibir mensagem, esperar 3 segundos e fechar o app
//TODO: Durante a contagem dos tres segundos, o valor deve ser exibido na tela
}