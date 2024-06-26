package com.smarthouse_mobile.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.smarthouse_mobile.R
import com.smarthouse_mobile.ui.main.model.Room
import com.smarthouse_mobile.ui.main.model.user

@Composable
fun AddRoomScreen(houseId: Int, navController: NavController) {
    val roomIcon = R.drawable.room
    val nameState = remember { mutableStateOf("Новая комната") }
    val descriptionState = remember { mutableStateOf("Описание") }


    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = roomIcon), contentDescription = "roomIcon")
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(PaddingValues(top = 100.dp)),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text = "Название", fontSize = 24.sp)
            TextField(value = nameState.value, onValueChange = {
                nameState.value = it
            })
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(PaddingValues(top = 100.dp)),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text = "Описание", fontSize = 24.sp)
            TextField(value = descriptionState.value, onValueChange = {
                descriptionState.value = it
            })
        }

      Button(onClick = {
          user.second[houseId]?.second?.put(
              user.second[houseId]?.second?.size?.plus(1) ?: -1, Pair(Room(
                  user.second[houseId]?.second?.size?.plus(1) ?: -1, nameState.value, descriptionState.value), mutableMapOf()))
          navController.popBackStack()
      },
          modifier = Modifier.padding(top = 30.dp)
      ) {
          Text(text = "Сохранить")
      }
    }
}