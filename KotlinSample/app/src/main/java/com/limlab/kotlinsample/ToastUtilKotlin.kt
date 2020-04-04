@file:JvmName("ToastUtil")

package com.limlab.kotlinsample

import android.widget.Toast

fun toastShort(message: String) {
    Toast.makeText(MainApplication.getAppContext(), message, Toast.LENGTH_SHORT).show()
}

fun toastLong(message: String) {
    Toast.makeText(MainApplication.getAppContext(), message, Toast.LENGTH_LONG).show()
}

@JvmOverloads
fun toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(MainApplication.getAppContext(), message, length).show()
}