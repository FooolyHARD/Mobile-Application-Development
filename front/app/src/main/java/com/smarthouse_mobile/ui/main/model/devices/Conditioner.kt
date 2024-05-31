package com.smarthouse_mobile.ui.main.model.devices

import com.smarthouse_mobile.R

data class Conditioner (
    override val id: Int,
    override val name: String,
    var isActive: Boolean = false,
    var temperature: Int = 20,
    var mode: ConditioningMode = ConditioningMode.FUN,
) : Device(id, name, R.drawable.conditioner_on)

enum class ConditioningMode {
    FUN,
    HEAT
}
