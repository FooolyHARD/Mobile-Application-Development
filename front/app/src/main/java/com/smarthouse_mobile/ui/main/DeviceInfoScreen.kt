package com.smarthouse_mobile.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.smarthouse_mobile.R
import com.smarthouse_mobile.simpleDevice
import com.smarthouse_mobile.ui.main.model.Room
import com.smarthouse_mobile.ui.main.model.devices.Color
import com.smarthouse_mobile.ui.main.model.devices.Conditioner
import com.smarthouse_mobile.ui.main.model.devices.ConditioningMode
import com.smarthouse_mobile.ui.main.model.devices.Device
import com.smarthouse_mobile.ui.main.model.devices.Lamp
import com.smarthouse_mobile.user

@Composable
fun DeviceInfoScreen(houseId: Int, roomId: Int, deviceId: Int, navController: NavController) {
    val device = user.second[houseId]?.second?.get(roomId)?.second?.get(deviceId) ?: simpleDevice
    DeviceInfoCard(device = device, navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeviceInfoCard(device: Device, navController: NavController) {
    val image = painterResource(id = device.resourceImage)
    Card(modifier = Modifier.fillMaxSize()) {
        when (device) {
            is Lamp -> LampScreen(lamp = device)
            is Conditioner -> ConditionerScreen(conditioner = device)
            else -> Card(
                //onClick = { navController.navigate("") }
            ) {
                Text(text = device.name)
            }
        }
    }
}