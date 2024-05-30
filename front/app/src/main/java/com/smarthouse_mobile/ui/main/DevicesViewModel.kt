package com.smarthouse_mobile.ui.main

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DevicesViewModelFactory(
    private val roomId: Int
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DevicesViewModel(roomId) as T
    }
}

class DevicesViewModel(private val roomId: Int): ViewModel() {
}