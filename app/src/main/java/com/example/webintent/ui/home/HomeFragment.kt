package com.example.webintent.ui.home

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.webintent.Constants.url
import com.example.webintent.ResProvider
import com.example.webintent.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var resProvider: ResProvider
    private lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setListeners()
        resProvider = ResProvider(requireContext())
        viewModelFactory = ViewModelFactory(resProvider)
        viewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)

        super.onViewCreated(view, savedInstanceState)
    }

    private fun setListeners() {
        binding.btnBrowser.setOnClickListener {
            startActivity(viewModel.getBrowserIntent())
        }

        binding.btnCustomTab.setOnClickListener {
            viewModel.getTabIntent().launchUrl(requireContext(), Uri.parse(url))
        }

        binding.btnWebView.setOnClickListener {
            navigate(HomeFragmentDirections.actionHomeFragmentToWebFragment())
        }
    }

    private fun navigate(navDirections: NavDirections) {
        findNavController().navigate(navDirections)
    }
}