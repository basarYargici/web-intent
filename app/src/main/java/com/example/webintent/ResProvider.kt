package com.example.webintent

import android.content.Context

class ResProvider(val context: Context) {
    fun getColor(resourceId: Int) = context.getColor(resourceId)
    fun getString(resourceId: Int) = context.getString(resourceId)
}