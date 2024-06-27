package com.smarthouse_mobile.ui.main.model.devices

import com.smarthouse_mobile.R

data class Motor (
    override val id: Int,
    override val name: String,
    var isActivated: Boolean = false,
) : Device(id, name, R.drawable.motor_on)
