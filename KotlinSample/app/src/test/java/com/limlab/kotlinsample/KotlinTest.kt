package com.limlab.kotlinsample

import org.junit.Assert
import org.junit.Test

class KotlinTest {
    @Test
    public fun testFruit(){
        val fruit1 = FruitKotlin("바나나", "바나나는 길어")
        val fruit2 = FruitKotlin("바나나", "바나나는 길어")

        println(fruit1)
        println(fruit2)

        Assert.assertEquals(fruit1, fruit2)

        Assert.assertEquals(fruit1.hashCode(), fruit2.hashCode())

    }

}