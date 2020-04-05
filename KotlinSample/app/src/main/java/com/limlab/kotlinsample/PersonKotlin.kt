package com.limlab.kotlinsample

class PersonKotlin (val name: String) {
    var age: Int = 0

    //닉네임 - 소문자만 허용
    var nickname: String =""
        set(value) {
        //field 는 Setter 의 대상이되는 field 를 의미
        field = value.toLowerCase()
    }
}