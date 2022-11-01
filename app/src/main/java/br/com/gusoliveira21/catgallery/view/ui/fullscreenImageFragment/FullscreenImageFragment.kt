package br.com.gusoliveira21.catgallery.view.ui.fullscreenImageFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import br.com.gusoliveira21.catgallery.databinding.FragmentFullscreenImageBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class FullscreenImageFragment : Fragment() {

    private val args: FullscreenImageFragmentArgs by navArgs()
    private val viewModel: FullscreenImageViewModel by viewModel { parametersOf(args) }
    private var _binding: FragmentFullscreenImageBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFullscreenImageBinding.inflate(inflater, container, false)
        setFullscreenImage()
        return binding.root
    }

    private fun setFullscreenImage() {
        viewModel.setFullscreenImageWithPalletColor(
            requireContext().applicationContext,
            binding.imageSource,
            binding.layoutFullscreen
        )


    }


}