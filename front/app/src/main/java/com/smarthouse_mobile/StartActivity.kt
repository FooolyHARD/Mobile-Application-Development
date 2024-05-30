package com.smarthouse_mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.smarthouse_mobile.ui.auth.AuthScreen
import com.smarthouse_mobile.ui.main.DevicesScreen
import com.smarthouse_mobile.ui.main.MainScreen
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
                            navController.navigate("main_screen")
                        }
                    }
                    composable("main_screen") {
                        MainScreen(navController)
                    }
                    composable("devices_screen/{roomId}") {
                        DevicesScreen(it.arguments?.getString("roomId")?.toInt() ?: -1)
                    }
                }
            }
        }
    }
}
