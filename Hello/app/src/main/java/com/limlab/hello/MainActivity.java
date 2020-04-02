package com.limlab.hello;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    /**
     * Main Activity 가 최초 실행될 때 실행된다.
     * 자바독 주석을 확인하려면 F1키를 누르자.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//         Activity의 UI를 R.layout.activity_main 으로 지정한다.
        setContentView(R.layout.activity_main);

//         "프로그래밍을 시작해보자" 메세지를 잠시 보여준다.
        Toast.makeText(getApplicationContext(),"프로그래밍을 시작해보자",Toast.LENGTH_LONG).show();

    }
}
