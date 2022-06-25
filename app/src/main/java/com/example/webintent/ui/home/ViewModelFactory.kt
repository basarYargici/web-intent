package com.example.webintent.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.webintent.ResProvider

class ViewModelFactory constructor(private val resProvider: ResProvider) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            HomeViewModel(this.resProvider) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}