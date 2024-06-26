package com.smarthouse_mobile.ui.main.model.devices

import com.smarthouse_mobile.R

data class Lamp (
    override val id: Int,
    override val name: String,
    var isActive: Boolean = false,
    val isColorful: Boolean = false,
    val color: Color = Color.WHITE,
    var brightness: Int = 100,
) : Device(id, name, R.drawable.lamp_on)
