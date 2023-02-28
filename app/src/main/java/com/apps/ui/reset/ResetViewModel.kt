package com.apps.ui.reset

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class ResetViewModel : ViewModel() {

    private val actionChannel = Channel<ResetActionClick>()
    val actionClick = actionChannel.receiveAsFlow()

    fun goBack() = viewModelScope.launch {
        actionChannel.send(ResetActionClick.Back)
    }

    fun resetPassword() = viewModelScope.launch {

    }

}