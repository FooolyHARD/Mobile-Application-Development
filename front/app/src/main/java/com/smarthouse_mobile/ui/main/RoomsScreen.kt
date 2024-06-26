package com.smarthouse_mobile.ui.main

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.smarthouse_mobile.R
import com.smarthouse_mobile.ui.main.model.Room
import com.smarthouse_mobile.ui.main.model.user

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RoomsScreen(houseId: Int, navController: NavController) {
    Scaffold(
        floatingActionButton = {
            LargeFloatingActionButton(
                onClick = {navController.navigate("houses/${houseId}/rooms/add") },
            ) {
                Icon(Icons.Filled.Add, "Floating action button.")
            }
        },
        floatingActionButtonPosition = FabPosition.End,
    ) {
        LazyColumn {
            items(user.second[houseId]?.second?.values?.toList() ?: emptyList()) {
                val route = "houses/${houseId}/rooms/${it.first.id}"
                RoomCard(it.first, route, navController)
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoomCard(room: Room, route: String, navController: NavController) {
    val image = painterResource(id = R.drawable.room)
    Card(
        onClick = { navController.navigate(route) }
    ) {
        Row(
            modifier = Modifier.fillMaxSize().padding(bottom = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = image, contentDescription = "lol")
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = room.name, fontSize = 28.sp, fontWeight = FontWeight.SemiBold, fontFamily = FontFamily.SansSerif)
                Text(text = room.description, fontSize = 22.sp)
            }
        }
    }
}