package com.smarthouse_mobile.ui.main.model.devices

data class Lamp (
    val name: String,
    val isActive: Boolean,
    val isColorful: Boolean,
    val color: Color = Color.WHITE,
    val brightness: Int
) : Device()
