package com.smarthouse_mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.smarthouse_mobile.ui.auth.AuthScreen
import com.smarthouse_mobile.ui.main.AddDeviceScreen
import com.smarthouse_mobile.ui.main.AddHouseScreen
import com.smarthouse_mobile.ui.main.AddRoomScreen
import com.smarthouse_mobile.ui.main.DeviceInfoScreen
import com.smarthouse_mobile.ui.main.DevicesScreen
import com.smarthouse_mobile.ui.main.HousesScreen
import com.smarthouse_mobile.ui.main.MainScreen
import com.smarthouse_mobile.ui.main.RoomsScreen
import com.smarthouse_mobile.ui.theme.SmartHouseMobileTheme

class StartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            SmartHouseMobileTheme {
                NavHost(
                    navController = navController,
                    startDestination = "auth_screen"
                ) {
                    composable("auth_screen") {
                        AuthScreen {
                            navController.popBackStack("auth_screen", true)
                            navController.navigate("houses")
                        }
                    }
                    composable("houses") {
                        MainScreen(navController)
                    }
                    composable("houses/add") {
                        AddHouseScreen(navController)
                    }
                    composable("houses/{houseId}/rooms") {
                        RoomsScreen(
                            it.arguments?.getString("houseId")?.toInt() ?: -1,
                            navController
                        )
                    }
                    composable("houses/{houseId}/rooms/add") {
                        AddRoomScreen(
                            it.arguments?.getString("houseId")?.toInt() ?: -1,
                            navController
                        )
                    }
                    composable("houses/{houseId}/rooms/{roomId}") {
                        DevicesScreen(
                            it.arguments?.getString("houseId")?.toInt() ?: -1,
                            it.arguments?.getString("roomId")?.toInt() ?: -1,
                            navController
                        )
                    }
                    composable("houses/{houseId}/rooms/{roomId}/devices/add") {
                        AddDeviceScreen(
                            it.arguments?.getString("houseId")?.toInt() ?: -1,
                            it.arguments?.getString("roomId")?.toInt() ?: -1,
                            navController
                        )
                    }
                    composable("houses/{houseId}/rooms/{roomId}/devices/{deviceId}") {
                        DeviceInfoScreen(
                            it.arguments?.getString("houseId")?.toInt() ?: -1,
                            it.arguments?.getString("roomId")?.toInt() ?: -1,
                            it.arguments?.getString("deviceId")?.toInt() ?: -1,
                            navController
                        )
                    }
                }
            }
        }
    }
}
