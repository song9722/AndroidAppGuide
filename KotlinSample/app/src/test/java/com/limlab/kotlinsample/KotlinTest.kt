package com.limlab.kotlinsample

import org.junit.Assert
import org.junit.Test

class KotlinTest {
    @Test
    fun testExtensions() {
        val str = "Hello, Extensions"
        Assert.assertEquals("s", str.lastString())
    }
}