package com.limlab.kotlinsample

fun String.lastString(): String {
    return this[this.length - 1].toString()
}

class ExtTest {
    fun String.extFunc() {
        println(this.lastString())
    }

    fun method1() {
        "test".extFunc()
    }
}

fun test() {
    "test".lastString()


}