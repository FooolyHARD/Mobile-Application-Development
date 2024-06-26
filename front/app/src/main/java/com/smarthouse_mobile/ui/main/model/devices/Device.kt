package com.smarthouse_mobile.ui.main.model.devices

sealed class Device(
    open val id: Int,
    open val name: String,
    val resourceImage: Int,
)
