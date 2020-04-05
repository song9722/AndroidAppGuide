package com.limlab.kotlinsample;

public class MagicSwordDelegate implements ISword {
    ISword iSword;

    //생성자에서 ISword 타입의 객체를 받는다
    public MagicSwordDelegate(ISword iSword) {
        this.iSword = iSword;
    }

    //장착시 불리는 메소드

    @Override
    public void equip() {
        //멋진 사운드를 플레이한다
        playWonderfulSound();

        //기존기능은 iSword에 위임한다.
        iSword.equip();
    }

    public void playWonderfulSound() {
        //멋진 사운드를 플레이한다
        System.out.println("짜잔");
    }
}
