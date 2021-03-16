package com.trackrider.android.ilabankdemoapp.utils

import android.app.Activity
import android.widget.Toast
import androidx.fragment.app.Fragment

private var toast: Toast? = null

/**
 * Methods to show toast from any activity/fragment
 *
 * @param message Message to be shown in toast
 * @param duration Amount of time toast is shown
 */
fun Activity.showToast(message: String, duration: Int = Toast.LENGTH_SHORT){
    toast?.cancel()
    toast = Toast.makeText(this, message, duration)
    toast?.show()
}

fun Fragment.showToast(message: String, duration: Int = Toast.LENGTH_SHORT){
    this.activity?.showToast(message, duration)
}