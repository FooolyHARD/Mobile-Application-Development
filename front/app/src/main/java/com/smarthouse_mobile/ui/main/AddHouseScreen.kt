package com.smarthouse_mobile.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
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
import com.smarthouse_mobile.user

@Composable
fun AddHouseScreen(navController: NavController) {
    val houseIcon = R.drawable.house
    val nameState = remember { mutableStateOf("New House") }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = houseIcon), contentDescription = "houseIcon")
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
      Button(onClick = {
          user.second[user.second.size + 1] = Pair(House(user.second.size + 1, nameState.value), mutableMapOf())
          navController.popBackStack()
      },
          modifier = Modifier.padding(top = 30.dp)) {
          Text(text = "Сохранить")
      }
    }
}