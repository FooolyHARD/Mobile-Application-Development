package com.smarthouse_mobile.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.navigation.NavController
import com.smarthouse_mobile.R
import com.smarthouse_mobile.ui.main.model.Room

@Composable
fun MainScreen(navController: NavController) {
    RoomsScreen(navController)
}

val roomsMock: List<Room> = listOf(
    Room(1, "Cпальня", "Спальня Саши"),
    Room(2, "Зал", "Зал на первом этаже"),
    Room(3, "Кухня", "Обычная кухня"),
    Room(4, "Гараж", "Лада приора")
)

@Composable
fun RoomsScreen(navController: NavController) {
    LazyColumn {
        items(roomsMock) {
            RoomCard(it, navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoomCard(room: Room, navController: NavController) {
    val image = painterResource(id = R.drawable.house)
    Card(
        onClick = { navController.navigate("devices_screen/${room.id}") }
    ) {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(painter = image, contentDescription = "lol")
            Column(
                modifier = Modifier.fillMaxSize().background(Color.Red),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = room.name)
                Text(text = room.description)
            }
        }
    }
}