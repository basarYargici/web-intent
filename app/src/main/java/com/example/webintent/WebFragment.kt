package com.example.webintent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.webintent.databinding.FragmentWebBinding

class WebFragment : Fragment() {
    private lateinit var binding: FragmentWebBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentWebBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.webView.apply {
            settings.javaScriptEnabled = true // allows the js files to run on website
            webViewClient = WebViewClient() // currently gives control to webview to navigate between pages
            loadUrl(Constants.url)
        }
    }
}