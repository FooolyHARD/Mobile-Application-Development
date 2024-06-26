package com.smarthouse_mobile.ui.main

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.smarthouse_mobile.ui.main.model.devices.Device
import com.smarthouse_mobile.ui.main.model.user

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DevicesScreen(houseId: Int, roomId: Int, navController: NavController) {
    val devices = user.second[houseId]?.second?.get(roomId)?.second?.values?.toList() ?: emptyList()
    Scaffold(
        floatingActionButton = {
            LargeFloatingActionButton(
                onClick = {navController.navigate("houses/${houseId}/rooms/${roomId}/devices/add") },
            ) {
                Icon(Icons.Filled.Add, "Floating action button.")
            }
        },
        floatingActionButtonPosition = FabPosition.End,
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),

            // content padding
            contentPadding = PaddingValues(
                start = 12.dp,
                top = 16.dp,
                end = 12.dp,
                bottom = 16.dp
            ),
            content = {
                items(
                    count = devices.size
                ) { device ->
                    val route = "houses/${houseId}/rooms/${roomId}/devices/${devices[device].id}"
                    DeviceCard(device = devices[device], route, navController = navController)
                }
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeviceCard(device: Device, route: String, navController: NavController) {
    val image = painterResource(id = device.resourceImage)
    Card(
        modifier = Modifier.padding(PaddingValues(all = 5.dp)),
        onClick = { navController.navigate(route) }
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(painter = image, contentDescription = "lol")
            Text(text = device.name)
        }
    }
}