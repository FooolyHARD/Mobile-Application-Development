package com.smarthouse_mobile.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smarthouse_mobile.R
import com.smarthouse_mobile.ui.main.model.devices.Lamp

@Composable
fun LampScreen(lamp: Lamp) {
    val lampOn = R.drawable.lamp_on
    val lampOff = R.drawable.lamp_off
    val isActiveState = remember { mutableStateOf(lamp.isActive) }
    val brightnessState = remember { mutableIntStateOf(lamp.brightness) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (isActiveState.value)
            Image(painter = painterResource(id = lampOn), contentDescription = "lamp")
        else
            Image(painter = painterResource(id = lampOff), contentDescription = "lamp")
        Row(
            modifier = Modifier.fillMaxWidth().padding(PaddingValues(top = 100.dp)),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            ) {
            Text(text = "Включить", fontSize = 24.sp)
            Switch(checked = isActiveState.value, onCheckedChange = {
                lamp.isActive = it
                isActiveState.value = it
            })
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
        ) {
            Text(text = "Яркость", fontSize = 24.sp)
            Text(text = brightnessState.intValue.toString(), fontSize = 24.sp, fontWeight = FontWeight.SemiBold, fontFamily = FontFamily.Monospace)
            Slider(
                modifier = Modifier.padding(PaddingValues(
                    start = 40.dp, end = 40.dp
                )),
                value = brightnessState.intValue.toFloat(),
                onValueChange = {
                    brightnessState.intValue = it.toInt()
                    lamp.brightness = it.toInt()
                },
                valueRange = (0f..100f),
                steps = 100)
        }
    }
}