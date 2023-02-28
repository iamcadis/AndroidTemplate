package com.apps.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apps.data.local.UserPrefs
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class HomeViewModel(private val prefs: UserPrefs) : ViewModel() {

    private val _userHasLogin = MutableStateFlow(prefs.authToken != null)
    val userHasLogin = _userHasLogin.asStateFlow()

    private val _greeting = MutableStateFlow("")
    val greeting = _greeting.asStateFlow()

    private val _currentDate = MutableStateFlow("")
    val currentDate = _currentDate.asStateFlow()

    fun checkUserHasLogin() = viewModelScope.launch {
        _userHasLogin.update { prefs.authToken != null }
    }

    fun removeToken() = viewModelScope.launch {
        prefs.authToken = null
        _userHasLogin.update { prefs.authToken != null }
    }

}