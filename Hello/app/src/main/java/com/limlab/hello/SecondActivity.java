package com.limlab.hello;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    //가속도가 3, 최고속도가 100, 브레이크속도가 4인 차를 만든다.
    Car car1 = new Car(3, 100, 4);

    //Car2는 스포츠카로 만든다.
    SportsCar car2 = new SportsCar(10, 50, 8);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //프로그래밍을 시작해보자 라는 메세지를 잠시 보여준다.
        Toast.makeText(getApplicationContext(), "프로그램을 시작해보자", Toast.LENGTH_SHORT).show();

        findViewById(R.id.testButton1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                car1.accelerationPedal();
                car2.accelerationPedal();
                String info = "car1: " + car1.getCurrentSpeedText() + ", car2: " + car2.getCurrentSpeedText();
                Toast.makeText(getApplicationContext(), info, Toast.LENGTH_SHORT).show();
                //스포츠카의 선루프를 연다.
                car2.openSunRoof();
                Toast.makeText(getApplicationContext(), car2.getSunRoofInfo(), Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.testButton2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                car1.brakePedal();
                car2.brakePedal();
                String info = "car1: " + car1.getCurrentSpeedText() + ", car2: " + car2.getCurrentSpeedText();
                Toast.makeText(getApplicationContext(), info, Toast.LENGTH_SHORT).show();

                //스포츠카의 선루프를 닫는다.
                car2.closeSunRoof();
                Toast.makeText(getApplicationContext(), car2.getSunRoofInfo(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}
