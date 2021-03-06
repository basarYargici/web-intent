package com.example.webintent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.webintent.Constants.url
import com.example.webintent.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding

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
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setListeners() {
        binding.btnBrowser.setOnClickListener {
            val webPage = Uri.parse(url)
            val intent = Intent(Intent.ACTION_VIEW, webPage)
            startActivity(intent)
        }

        binding.btnCustomTab.setOnClickListener {
            val customTabsIntent = customTabIntentBuilder().build()
            customTabsIntent.launchUrl(requireContext(), Uri.parse(url))
        }

        binding.btnWebView.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToWebFragment())
        }
    }

    private fun customTabIntentBuilder(): CustomTabsIntent.Builder = CustomTabsIntent.Builder()
        .setUrlBarHidingEnabled(true)
        .setShowTitle(true)
        .setShareState(CustomTabsIntent.SHARE_STATE_OFF)
        .setDefaultColorSchemeParams(
            CustomTabColorSchemeParams.Builder()
                .setToolbarColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.purple_200
                    )
                ).build()
        )
}