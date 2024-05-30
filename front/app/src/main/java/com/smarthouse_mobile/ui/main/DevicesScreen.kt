package com.smarthouse_mobile.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.smarthouse_mobile.ui.main.model.devices.Color
import com.smarthouse_mobile.ui.main.model.devices.Conditioner
import com.smarthouse_mobile.ui.main.model.devices.ConditioningMode
import com.smarthouse_mobile.ui.main.model.devices.Device
import com.smarthouse_mobile.ui.main.model.devices.Lamp

private val devicesMap = mapOf<Int, List<Device>>(
    Pair(1, listOf(
        Lamp("Lamp 1", true, true, Color.WHITE, 1),
        Lamp("Lamp 2", true, true, Color.WHITE, 1),
        Lamp("Lamp 3", true, true, Color.WHITE, 1),
        Conditioner("cond", false, 20, ConditioningMode.FUN)
    )),
    Pair(2, listOf(
        Lamp("Lamp 1", true, true, Color.WHITE, 1),
        Lamp("Lamp 2", true, true, Color.WHITE, 1),
        Lamp("Lamp 3", true, true, Color.WHITE, 1),
        Conditioner("cond", false, 20, ConditioningMode.FUN)
    )),
    Pair(3, listOf(
        Lamp("Lamp 1", true, true, Color.WHITE, 1),
        Lamp("Lamp 2", true, true, Color.WHITE, 1),
        Lamp("Lamp 3", true, true, Color.WHITE, 1),
        Conditioner("cond", false, 20, ConditioningMode.FUN)
    )),
    Pair(4, listOf(
        Lamp("Lamp 1", true, true, Color.WHITE, 1),
        Lamp("Lamp 2", true, true, Color.WHITE, 1),
        Lamp("Lamp 3", true, true, Color.WHITE, 1),
        Conditioner("cond", false, 20, ConditioningMode.FUN)
    ))
)


@Composable
fun DevicesScreen(roomId: Int) {
    val devicesViewModel : DevicesViewModel = viewModel(factory = DevicesViewModelFactory(roomId))
    Box(
        contentAlignment = Alignment.Center
    ) {
        Text(text = roomId.toString(), modifier = Modifier.size(30.dp))
    }
}