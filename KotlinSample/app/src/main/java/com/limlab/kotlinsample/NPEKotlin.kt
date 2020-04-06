package com.limlab.kotlinsample

fun strLenNonNull(str: String): Int {
    return str.length
}

fun strLenNullable(str: String?): Int {

    return str?.length ?: 0
}