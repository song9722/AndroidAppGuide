package com.limlab.hello;

public class SportsCar extends Car {

    private boolean isOpenSunRoof = false;

    public SportsCar(int acceleration, int maxSpeed, int brakeSpeed) {
        super(acceleration, maxSpeed, brakeSpeed);
    }

    public void openSunRoof() {
        isOpenSunRoof = true;
    }

    public void closeSunRoof() {
        isOpenSunRoof = false;
    }

    //스포츠카의 선루프 정보를 읽어온다
    public String getSunRoofInfo() {
        if (isOpenSunRoof) {
            return "선루프를 열었더니 시원하다.";
        } else {
            return "선루프는 닫혀있다.";
        }
    }

    @Override
    public String getCurrentSpeedText() {
        return "스포츠카입니다. " + super.getCurrentSpeedText();
    }
}
