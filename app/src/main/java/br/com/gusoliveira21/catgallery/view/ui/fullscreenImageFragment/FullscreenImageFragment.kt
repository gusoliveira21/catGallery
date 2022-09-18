package br.com.gusoliveira21.catgallery.view.ui.fullscreenImageFragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import br.com.gusoliveira21.catgallery.databinding.FragmentFullscreenImageBinding


class FullscreenImageFragment : Fragment() {

    private var _binding: FragmentFullscreenImageBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFullscreenImageBinding.inflate(inflater, container, false)
        return binding.root

    }
}