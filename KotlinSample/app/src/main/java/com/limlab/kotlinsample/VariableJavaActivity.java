package com.limlab.kotlinsample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class VariableJavaActivity extends AppCompatActivity {

    // 버튼이 클린된 횟수를 저장할 변수
    int clickCount = 0;
    // Activity의 시작시간을 저장하는 변수
    final long START_TIME = System.currentTimeMillis();
    // Activity의 시작시간을 보여주는 TextView
    TextView startTimeLabel;
    // 버튼의 클릭횟수를 보여주는 TextView
    TextView clickCountLabel;
    // 클릭버튼
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_variable);

        // 레이아웃에서 startTimeLabel 을 찾아 바인딩한다.
        startTimeLabel = findViewById(R.id.startTimeLabel);
        // 레이아웃에서 clickCountLabel 을 찾아 바인딩한다.
        clickCountLabel = findViewById(R.id.clickCountLabel);
        // 레이아웃에서 button 을 찾아 바인딩한다.
        button = findViewById(R.id.button);
        // 시작시간을 텍스트 형태로 변환
        String timeText = new SimpleDateFormat("HH:mm:ss", Locale.KOREA).format(START_TIME);

        // 시작시간을 TextView에 보여줌
        startTimeLabel.setText("Activity 시작시간 : " + timeText);
        // 클릭된 횟수를 보여줌
        clickCountLabel.setText("클릭횟수 : " + clickCount);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 클릭횟수를 증가시킴
                clickCount += 1;
                // 클릭된 횟수를 다시 보여줌
                clickCountLabel.setText("클릭횟수 : " + clickCount);

            }
        });




    }
}
