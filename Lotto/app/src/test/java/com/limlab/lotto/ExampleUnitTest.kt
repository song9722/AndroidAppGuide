package com.limlab.lotto

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun testShuffleLottoNumbers(){
        val list = mutableListOf<Int>()

        for (num in 1..45) {
            list.add(num)
        }

        list.shuffle()

        println(list.subList(0, 6))
    }


}
