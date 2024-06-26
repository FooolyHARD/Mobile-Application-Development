package com.smarthouse_mobile.ui.main

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.smarthouse_mobile.R
import com.smarthouse_mobile.ui.main.model.House
import com.smarthouse_mobile.ui.main.model.user

@Composable
fun MainScreen(navController: NavController) {
    HousesScreen(navController)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HousesScreen(navController: NavController) {
    Scaffold(
        floatingActionButton = {
            LargeFloatingActionButton(
                onClick = {navController.navigate("houses/add") },
            ) {
                Icon(Icons.Filled.Add, "Floating action button.")
            }
        },
        floatingActionButtonPosition = FabPosition.End,
        ) {
        LazyColumn {
            items(user.second.values.toList()) {
                HouseCard(it.first, navController)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HouseCard(house: House, navController: NavController) {
    val image = painterResource(id = R.drawable.house)
    Card(
        onClick = { navController.navigate("houses/${house.id}/rooms") }
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = image, contentDescription = "lol")
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(text = house.name, fontSize = 32.sp, fontWeight = FontWeight.SemiBold)
            }
        }
    }
}