package com.limlab.kotlinsample

//Animal 클래스는 map 객체를 생성자에서 받는다
class Animal(val map: MutableMap<String, Any?>) {
    var name: String by map
    var age: Int by map
}
