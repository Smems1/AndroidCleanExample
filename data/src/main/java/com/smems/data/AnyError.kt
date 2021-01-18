package com.smems.data

import android.content.Context
import androidx.annotation.StringRes

data class AnyError(
    @AnyErrorType val type: Int,
    @StringRes val messageRes: Int = R.string.error_unknown,
    val message: String = ""
) {
    fun getString(context: Context): String =
        if (message.isEmpty()) context.getString(messageRes) else message
}

@Retention(AnnotationRetention.RUNTIME)
annotation class AnyErrorType