package com.smarthouse_mobile.ui.main

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class DevicesViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    val roomId = savedStateHandle["roomId"] ?: -1
}