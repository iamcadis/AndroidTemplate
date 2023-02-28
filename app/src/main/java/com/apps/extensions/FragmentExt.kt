package com.apps.extensions

import android.os.Build
import android.os.Bundle
import android.window.OnBackInvokedDispatcher
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

/**
 * Observe changes on state flow
 */
fun <T> Fragment.observeFlow(data: Flow<T>, action: (t: T) -> Unit) {
    viewLifecycleOwner.lifecycleScope.launch {
        data.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
            .collect { action(it) }
    }
}

/**
 * Register action callback on button back pressed
 */
fun Fragment.addOnBackPressedDispatcher(action: () -> Unit) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        activity?.onBackInvokedDispatcher?.registerOnBackInvokedCallback(
            OnBackInvokedDispatcher.PRIORITY_DEFAULT) { action.invoke() }
    } else {
        activity?.onBackPressedDispatcher?.addCallback(this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    action.invoke()
                }
            }
        )
    }
}

/**
 * Simplify get fragment result listener
 */
fun Fragment.getFragmentResult(key: String, action: (Bundle) -> Unit) {
    setFragmentResultListener(key) { _, bundle -> action.invoke(bundle) }
}

/**
 * Send data to previous fragment
 * closeApp -> true if want to close current page
 */
fun Fragment.sendDataToPrevFragment(key: String, bundle: Bundle, closePage: Boolean = true) {
    setFragmentResult(key, bundle)
    if (closePage) findNavController().popBackStack()
}

/**
 * Handle error from api
 */
fun Fragment.handleErrorApi(exception: Exception) {
//    val container = activity?.findViewById<View>(android.R.id.content)
//    val newView = if (this is BaseFragment<*>) container else view
//    val onAction = if (exception.errorCode == ErrorCode.NO_INTERNET) {
//        when (this) {
//            is BaseFragment<*> -> getString(R.string.retry) to { onRetryRequest(exception.requestCode) }
//            is BaseSheet<*> -> getString(R.string.retry) to { onRetryRequest(exception.requestCode) }
//            is BaseDialog<*> -> getString(R.string.retry) to { onRetryRequest(exception.requestCode) }
//            else -> null
//        }
//    } else null

//    val length = when (exception.cause) {
//        ErrorCode.NO_INTERNET -> Snackbar.LENGTH_INDEFINITE
//        else -> Snackbar.LENGTH_LONG
//    }

//    newView?.let { anchor ->
//        val color = context?.getColorByAttr(androidx.appcompat.R.attr.colorError) ?: return
//        val message = getString(exception.getMessageId())
//        anchor.showSnackMessage(message, length, color, onAction)
//    }
}