package com.limlab.kotlinsample;

public class PersonJava {
    //나이
    private int age;

    //이름, 변경 불가
    private final String name;

    private String nickname;

    //생성자에서 이름을 받는다
    public PersonJava(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname.toLowerCase();
    }

}
