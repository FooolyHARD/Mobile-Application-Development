package com.smarthouse_mobile.ui.main

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModel

class DevicesViewModel(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val roomId = savedStateHandle["roomId"] ?: -1
}