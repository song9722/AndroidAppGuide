package com.limlab.kotlinsample

import org.junit.Assert
import org.junit.Test

class KotlinTest {
    @Test
    fun testCollectionApi() {
        val list = listOf(1, "2", 3, 4, 5.7, 1, 2)

        //filter: 컬렉션에서 특정조건이 맞는 항목만 추출하여 새로운 컬렉션을 만든다. -> Int 타입만 추출
        println(list.filter {it is Int})

        //map: 컬렉션에서 아이템을 변환하여 새로운 컬렉션을 만든다. -> String 의 컬렉션이 만들어 진다.
        println(list.map {"value : $it"})

        //filter 에서 반환된 컬렌션을 map 으로 변환
        println(list.filter { it is Int }.map{"value : $it"})

        //find: 아이템을 찾는다
        println(list.find { it is Double })

        //groupBy: 컬렉션을 그룹화하여 Map<String, List<T>> 형태로 만든다. 아래코드는 각 아이템의 클래스별로 그룹화된다.
        val map = list.groupBy { it.javaClass }
        println(map)

        //컬렉션안에 컬렉션이 있는 새로운 리스트를 만든다.
        val list2 = listOf(listOf(1, 2), listOf(3, 4))
        println(list2)

        println(list2.map{ "value : $it"})

        //flatmap 으로 리스트를 평평하게 만들고 변환한다.
        println(list2.flatMap { it.toList() })
    }
}