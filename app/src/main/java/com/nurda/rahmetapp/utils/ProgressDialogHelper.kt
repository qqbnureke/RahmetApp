package com.nurda.rahmetapp.utils

import android.app.ProgressDialog
import android.content.Context
import com.nurda.rahmetapp.R

class ProgressDialogHelper(context: Context) {

    private var progressDialog: ProgressDialog? = null
    private var message: String? = null

    init {
        if (progressDialog == null) {
            progressDialog = ProgressDialog(context)
            message = context.getString(R.string.loading)
        }
    }

    @Synchronized
    fun show() {
        progressDialog!!.setMessage(message)
        progressDialog!!.setCancelable(false)
        progressDialog!!.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        progressDialog!!.show()
    }

    @Synchronized
    fun dismiss() {
        if (progressDialog == null) {
            return
        }

        progressDialog!!.dismiss()
    }
}