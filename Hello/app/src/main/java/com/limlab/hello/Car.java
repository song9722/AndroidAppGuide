package com.limlab.hello;

public class Car {
    //현재 속도
    private int currentSpeed = 0;

    //최고 속도
    private int maxSpeed = 100;

    //가속도
    private int acceleration = 3;

    //브레이크 속도
    private int brakeSpeed = 4;

    //생성자
    public Car(int acceleration, int maxSpeed, int brakeSpeed) {
        this.acceleration = acceleration;
        this.maxSpeed = maxSpeed;
        this.brakeSpeed = brakeSpeed;
    }

    //자동차 엑세를 밟는 메소드
    public void accelerationPedal() {
        currentSpeed += acceleration;
        if (currentSpeed > maxSpeed) {
            currentSpeed = maxSpeed;
        }
    }

    public void brakePedal() {
        currentSpeed -= brakeSpeed;
        if (currentSpeed < 0) {
            currentSpeed = 0;
        }
    }

    public String getCurrentSpeedText() {
        return "현재속도는 " + this.currentSpeed + " km/h 입니다.";
    }
}
