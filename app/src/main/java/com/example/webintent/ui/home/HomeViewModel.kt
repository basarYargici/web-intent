package com.example.webintent.ui.home

import android.content.Intent
import android.net.Uri
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.browser.customtabs.CustomTabsIntent
import androidx.lifecycle.ViewModel
import com.example.webintent.Constants
import com.example.webintent.R
import com.example.webintent.ResProvider

class HomeViewModel(private val resProvider: ResProvider) : ViewModel() {
    fun getBrowserIntent(): Intent {
        val webPage = Uri.parse(Constants.url)
        return Intent(Intent.ACTION_VIEW, webPage)
    }

    fun getTabIntent() = getTabIntentBuilder().build()

    private fun getTabIntentBuilder(): CustomTabsIntent.Builder = CustomTabsIntent.Builder()
        .setUrlBarHidingEnabled(true)
        .setShowTitle(true)
        .setShareState(CustomTabsIntent.SHARE_STATE_OFF)
        .setDefaultColorSchemeParams(
            CustomTabColorSchemeParams.Builder()
                .setToolbarColor(resProvider.getColor(R.color.purple_200))
                .build()
        )
}