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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.smarthouse_mobile.R
import com.smarthouse_mobile.ui.main.model.Room

@Composable
fun MainScreen(onRoomClick: (Int) -> Unit) {
    RoomsScreen()
}

val roomsMock: List<Room> = listOf(
    Room("Спальня", "Спальня Маши"),
    Room("Cпальня", "Спальня Саши"),
    Room("Зал", "Зал на первом этаже"),
    Room("Кухня", "Обычная кухня"),
    Room("Гараж", "Лада приора")
)

@Composable
fun RoomsScreen() {
    LazyColumn {
        items(roomsMock) {
            RoomCard(it)
        }
    }
}

@Composable
fun RoomCard(room: Room) {
    val image = painterResource(id = R.drawable.house)
    Card(
        onClick =
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