package com.smarthouse_mobile.ui.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.smarthouse_mobile.R
import com.smarthouse_mobile.ui.main.model.devices.Conditioner
import com.smarthouse_mobile.ui.main.model.devices.ConditioningMode
import com.smarthouse_mobile.ui.main.model.devices.Lamp

@Composable
fun ConditionerScreen(conditioner: Conditioner) {
    val conditionerOn = R.drawable.conditioner_on
    val conditionerOff = R.drawable.conditioner_off
    val isActiveState = remember { mutableStateOf(conditioner.isActive) }
    val tempState = remember { mutableIntStateOf(conditioner.temperature) }
    val modeState = remember { mutableStateOf(conditioner.mode) }
    val cornerRadius = 16.dp
    val selectedIndex = remember { mutableIntStateOf(if (conditioner.mode == ConditioningMode.FUN) 0 else 1) }
    val buttonList = listOf(ConditioningMode.FUN.name, ConditioningMode.HEAT.name)
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (isActiveState.value)
            Image(painter = painterResource(id = conditionerOn), contentDescription = "cond")
        else
            Image(painter = painterResource(id = conditionerOff), contentDescription = "cond")
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(PaddingValues(top = 100.dp)),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            ) {
            Text(text = "Включить", fontSize = 24.sp)
            Switch(checked = isActiveState.value, onCheckedChange = {
                conditioner.isActive = it
                isActiveState.value = it
            })
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
        ) {
            Text(text = "Температура", fontSize = 24.sp)
            Text(text = tempState.intValue.toString(), fontSize = 24.sp, fontWeight = FontWeight.SemiBold, fontFamily = FontFamily.Monospace)
            Slider(
                modifier = Modifier.padding(PaddingValues(
                    start = 40.dp, end = 40.dp
                )),
                value = tempState.intValue.toFloat(),
                onValueChange = {
                    tempState.intValue = it.toInt()
                    conditioner.temperature = it.toInt()
                },
                valueRange = (13f..32f),
                steps = 10)
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
        ) {
            Text(text = "Режим", fontSize = 24.sp)
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {



                buttonList.forEachIndexed { index, item ->

                    OutlinedButton(
                        onClick = { selectedIndex.intValue = index },
                        modifier = when (index) {
                            0 ->
                                Modifier
                                    .offset(0.dp, 0.dp)
                                    .zIndex(if (selectedIndex.intValue == index) 1f else 0f)
                            else ->
                                Modifier
                                    .offset((-1 * index).dp, 0.dp)
                                    .zIndex(if (selectedIndex.intValue == index) 1f else 0f)
                        },
                        shape = when (index) {
                            0 -> RoundedCornerShape(
                                topStart = cornerRadius,
                                topEnd = 0.dp,
                                bottomStart = cornerRadius,
                                bottomEnd = 0.dp
                            )
                            buttonList.size - 1 -> RoundedCornerShape(
                                topStart = 0.dp,
                                topEnd = cornerRadius,
                                bottomStart = 0.dp,
                                bottomEnd = cornerRadius
                            )
                            else -> RoundedCornerShape(
                                topStart = 0.dp,
                                topEnd = 0.dp,
                                bottomStart = 0.dp,
                                bottomEnd = 0.dp
                            )
                        },
                        border = BorderStroke(
                            1.dp, if (selectedIndex.intValue == index) {
                                 Color.Blue
                            } else {
                                Color.Blue.copy(alpha = 0.75f)
                            }
                        ),
                        colors = if (selectedIndex.intValue == index) {
                            ButtonDefaults.outlinedButtonColors(
                                containerColor = Color.Blue.copy(alpha = 0.1f),
                                contentColor = Color.Blue
                            )
                        } else {
                            ButtonDefaults.outlinedButtonColors(
                                containerColor = MaterialTheme.colorScheme.surface,
                                contentColor = Color.Blue
                            )
                        }
                    ) {
                        Text(text = item)
                    }
                }
            }
        }
    }
}