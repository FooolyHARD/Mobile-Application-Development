package com.smarthouse_mobile.ui.auth

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {
    var login by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private set

    var authStatus by mutableStateOf(AuthStatus.OK)

    fun updateLogin(newNumber: String) {
        login = newNumber
    }

    fun updatePassword(newPassword: String) {
        password = newPassword
    }


    fun authorize() : Boolean {
        Log.d("INFO", login)
        Log.d("INFO", password)
        if (login != "1234") {
            authStatus = AuthStatus.WRONG_LOGIN
            return false
        }
        if (password != "1234") {
            authStatus = AuthStatus.WRONG_PASSWORD
            return false
        }
        return true
    }
}