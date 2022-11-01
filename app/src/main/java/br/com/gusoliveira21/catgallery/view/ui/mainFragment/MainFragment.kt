package br.com.gusoliveira21.catgallery.view.ui.mainFragment

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.GridLayoutManager
import br.com.gusoliveira21.catgallery.R
import br.com.gusoliveira21.catgallery.databinding.MainFragmentBinding
import br.com.gusoliveira21.catgallery.view.ui.mainFragment.adapter.MainFragmentAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

@Suppress("NAME_SHADOWING")
class MainFragment : Fragment() {
    private val navController by lazy { findNavController() }

    private val viewModel: MainViewModel by viewModel { parametersOf(navController) }

    private lateinit var binding: MainFragmentBinding

    private var adapter = MainFragmentAdapter { viewModel.onImageClicked(it) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
        val search: MenuItem? = menu.findItem(R.id.bar_search)
        val editSearch: SearchView? = search?.actionView as? SearchView
        editSearch?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(word: String?): Boolean {
                viewModel.getCatList(word!!)
                val editSearch: SearchView? = search.actionView as? SearchView
                editSearch?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

                    override fun onQueryTextSubmit(p0: String?): Boolean {
                        viewModel.getCatList(p0!!)
                        editSearch.clearFocus()
                        return false
                    }

                    override fun onQueryTextChange(p0: String?): Boolean {
                        Log.e("teste", "Mudando -> $p0")
                        return false
                    }

                })
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                Log.e("teste", "Mudando!")
                return false
            }

        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.catList.observe(viewLifecycleOwner, Observer(::adapter))
        viewModel.error.observe(viewLifecycleOwner, Observer(::showError))
    }


    private fun showResearchField() {
        //TODO: Exibir a toolbar só depois da splash
    }

    private fun adapter(catUriList: MutableList<String>) {
        adapter.catUriList = catUriList
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 4)
        binding.recyclerView.adapter = adapter
        showResearchField()
    }

    private fun showError(message: String) {
        binding.textAviso.visibility = View.VISIBLE
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

//TODO: Caso nao tenha internet, exibir mensagem, esperar 3 segundos e fechar o app
//TODO: Durante a contagem dos tres segundos, o valor deve ser exibido na tela
}