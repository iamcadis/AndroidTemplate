package com.apps.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apps.data.local.UserPrefs
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class LoginViewModel(private val prefs: UserPrefs) : ViewModel() {

    private val actionChannel = Channel<LoginActionClick>()
    val actionClick = actionChannel.receiveAsFlow()

    fun openForgotPage() = viewModelScope.launch {
        actionChannel.send(LoginActionClick.ForgotPassword)
    }

    fun login() = viewModelScope.launch {
        prefs.authToken = "Tester"
    }

}