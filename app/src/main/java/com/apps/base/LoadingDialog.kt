package com.apps.base

import android.app.Dialog
import android.content.Context
import android.view.Window
import android.widget.ProgressBar

class LoadingDialog(context: Context) {

    private var dialog: Dialog = Dialog(context)

    fun show() {
        if (!dialog.isShowing) dialog.show()
    }

    fun dismiss() {
        if (dialog.isShowing) dialog.dismiss()
    }

    init {
        val progressBar = ProgressBar(context)
        progressBar.isIndeterminate = true

        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(progressBar)
        dialog.setCancelable(false)
    }
}