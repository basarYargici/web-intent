package com.example.webintent

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import com.example.webintent.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()
    }

    private fun setListeners() {
        binding.btnCustomTab.setOnClickListener {
            val url = "https://stackoverflow.com/questions/2808796/what-is-an-android-pendingintent"
            val customTabsIntent = customTabIntentBuilder().build()
            customTabsIntent.launchUrl(this, Uri.parse(url))
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
                        this,
                        R.color.purple_200
                    )
                ).build()
        )
}