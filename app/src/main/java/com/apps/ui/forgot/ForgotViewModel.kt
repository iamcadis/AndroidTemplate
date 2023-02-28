package com.apps.ui.forgot

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class ForgotViewModel : ViewModel() {

    private val actionChannel = Channel<ForgotActionClick>()
    val actionClick = actionChannel.receiveAsFlow()

    fun goBack() = viewModelScope.launch {
        actionChannel.send(ForgotActionClick.Back)
    }

    fun forgotPassword() = viewModelScope.launch {

    }

}