package com.limlab.kotlinsample;

public class SingletonJava {
    //생성자를 private으로 감춘다.
    private SingletonJava(){}

    //생성된 객체를 private 으로 감추고 프로그램 시작할때 초기화 한다.
    //인스턴스 생성방법은 처음 사용할때 초기화하는 방법, 쓰레드 동기화 방법등 다양한 방법이 있다.
    private static SingletonJava instance = new SingletonJava();

    //외부에서 생성된 instance 에 접근할 수 있는 방법을 제공
    public static SingletonJava getInstance() {
        return instance;
    }

    public void log(String text) {
        System.out.println(text);
    }

}
