package com.smarthouse_mobile.ui.auth

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.smarthouse_mobile.R

@Composable
fun AuthScreen(
    authViewModel: AuthViewModel = viewModel(),
    onAuthorizeClick: () -> Unit
) {
    var passwordVisibility = remember { mutableStateOf(false) }
    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color.Gray)
            .fillMaxSize()
    ) {
        Text(color = Color.White, text = "Authorize")
        TextField(value = authViewModel.login, onValueChange = { authViewModel.updateLogin(it) }, placeholder = { Text(text = "Login") })
        AnimatedVisibility(
            visible = authViewModel.authStatus == AuthStatus.WRONG_LOGIN,
            enter = fadeIn()
        ) {
            Text(text = "Wrong login", color = Color.Red)
        }
        TextField(
            value = authViewModel.password,
            onValueChange = { authViewModel.updatePassword(it) },
            placeholder = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation()
        )
        AnimatedVisibility(
            visible = authViewModel.authStatus == AuthStatus.WRONG_PASSWORD,
            enter = fadeIn()
        ) {
            Text(text = "Wrong password", color = Color.Red)
        }
        Button(
            onClick = {
                if (authViewModel.authorize())
                    onAuthorizeClick()
            }
        ) {
            Text(text = "Log in")
        }
    }
}