package com.smarthouse_mobile.ui.main.model.devices

data class Conditioner (
    val name: String,
    val isActive: Boolean,
    val temperature: Int,
    val mode: ConditioningMode
) : Device()

enum class ConditioningMode {
    FUN,
    HEAT
}
