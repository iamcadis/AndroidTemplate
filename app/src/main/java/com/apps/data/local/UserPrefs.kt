package com.apps.data.local

import android.content.Context
import androidx.core.content.edit
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import org.koin.core.annotation.Single

@Single
class UserPrefs(appContext: Context) {

    private val keyAlias by lazy { MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC) }
    private val preferences by lazy {
        EncryptedSharedPreferences.create(SHARED_PREF_NAME, keyAlias, appContext,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    var authToken: String?
        get() = preferences.getString(AUTH_TOKEN, null)
        set(value) = preferences.edit {
            putString(AUTH_TOKEN, value)
        }

    companion object {
        private const val SHARED_PREF_NAME = "local.user_prefs"
        private const val AUTH_TOKEN = "key.prefs.auth_token"
    }

}