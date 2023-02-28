package com.apps.utils

import androidx.databinding.InverseMethod

object Converter {

    @InverseMethod("intToString")
    @JvmStatic
    fun stringToInt(value: String?): Int? {
        return try { value?.toIntOrNull() } catch (e: NumberFormatException) { null }
    }

    @JvmStatic
    fun intToString(value: Int?): String? {
        return value?.toString()
    }

}