package com.smarthouse_mobile.ui.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.smarthouse_mobile.ui.main.model.simpleDevice
import com.smarthouse_mobile.ui.main.model.devices.Conditioner
import com.smarthouse_mobile.ui.main.model.devices.Device
import com.smarthouse_mobile.ui.main.model.devices.Lamp
import com.smarthouse_mobile.ui.main.model.devices.Motor
import com.smarthouse_mobile.ui.main.model.user

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
            is Motor -> MotorScreen(motor = device)
            else -> Card(
                //onClick = { navController.navigate("") }
            ) {
                Text(text = device.name)
            }
        }
    }
}