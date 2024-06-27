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
import com.smarthouse_mobile.ui.main.model.devices.Motor

@Composable
fun MotorScreen(motor: Motor) {
    val motorOn = R.drawable.motor_on
    val motorOff = R.drawable.motor_off
    val isActiveState = remember { mutableStateOf(motor.isActivated) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (isActiveState.value)
            Image(painter = painterResource(id = motorOn), contentDescription = "motor")
        else
            Image(painter = painterResource(id = motorOff), contentDescription = "motor")
        Row(
            modifier = Modifier.fillMaxWidth().padding(PaddingValues(top = 100.dp)),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            ) {
            Text(text = "Включить", fontSize = 24.sp)
            Switch(checked = isActiveState.value, onCheckedChange = {
                motor.isActivated = it
                isActiveState.value = it
            })
        }
    }
}