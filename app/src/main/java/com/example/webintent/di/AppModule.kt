package com.example.webintent.di

import android.content.Context
import com.example.webintent.App
import com.example.webintent.ResProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext context: Context): App {
        return context as App
    }

    @Singleton
    @Provides
    fun provideResProvider(@ApplicationContext context: Context): ResProvider {
        return ResProvider(context)
    }
}