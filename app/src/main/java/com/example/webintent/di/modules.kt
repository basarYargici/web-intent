package com.example.webintent.di

import com.example.webintent.ResProvider
import com.example.webintent.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { ResProvider(get()) }

    viewModel { HomeViewModel(get()) }
}