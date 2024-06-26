package com.smarthouse_mobile.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.smarthouse_mobile.R
import com.smarthouse_mobile.ui.main.model.House
import com.smarthouse_mobile.ui.main.model.Room
import com.smarthouse_mobile.ui.main.model.devices.Conditioner
import com.smarthouse_mobile.ui.main.model.devices.Lamp
import com.smarthouse_mobile.user

@Composable
fun AddDeviceScreen(houseId: Int, roomId: Int, navController: NavController) {
    val lampIcon = R.drawable.lamp_on
    val conditionerIcon = R.drawable.conditioner_off
    val devices = listOf(Pair("Лампочка", lampIcon), Pair("Кондиционер", conditionerIcon))
    val deviceTypeState = remember {
        mutableIntStateOf(-1)
    }
    val nameState = remember { mutableStateOf("Новое устройство") }
    val onClick = { type: Int -> {
            deviceTypeState.intValue = type
    }}

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(PaddingValues(top = 100.dp)),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ) {

        }
        Text(text = "Название устройства", fontSize = 24.sp)
        TextField(value = nameState.value, onValueChange = {
            nameState.value = it
        })
        Text(text = "Тип устройства", fontSize = 24.sp)
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),

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
                    DeviceAddCard(devices[device].first, devices[device].second, device, deviceTypeState, onClick(device))
                }
            }
        )

      Button(onClick = {
          when (deviceTypeState.intValue) {
              0 -> user.second[houseId]?.second?.get(roomId)?.second?.put(user.second[houseId]?.second?.get(roomId)?.second?.size?.plus(1) ?: -1, Lamp(user.second[houseId]?.second?.get(roomId)?.second?.size?.plus(1) ?: -1, nameState.value))
              1 -> user.second[houseId]?.second?.get(roomId)?.second?.put(user.second[houseId]?.second?.get(roomId)?.second?.size?.plus(1) ?: -1, Conditioner(user.second[houseId]?.second?.get(roomId)?.second?.size?.plus(1) ?: -1, nameState.value))
          }
          navController.popBackStack()
      },
          modifier = Modifier.padding(top = 30.dp)
      ) {
          Text(text = "Сохранить")
      }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeviceAddCard(name: String, icon: Int, type: Int, deviceTypeState: MutableIntState, onClick: () -> Unit) {
    val image = painterResource(id = icon)
    Card(
        modifier = Modifier.padding(PaddingValues(all = 5.dp)),
        onClick = { onClick() }
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(painter = image, contentDescription = "lol")
            Text(text = name)
            if (deviceTypeState.intValue == type)
                Text("Выбрано")
        }
    }
}