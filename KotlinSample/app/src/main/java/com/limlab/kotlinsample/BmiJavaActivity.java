package com.limlab.kotlinsample;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BmiJavaActivity extends AppCompatActivity {

    EditText tallField;
    EditText weightField;
    TextView resultLabel;
    Button bmiButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_view_binding);

        tallField = findViewById(R.id.tallField);
        weightField = findViewById(R.id.weightField);
        resultLabel = findViewById(R.id.resultLabel);
        bmiButton = findViewById(R.id.bmiButton);

        // bmiButton 이 클린된 경우의 이벤트 리스너를 등록한다.
        bmiButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                String tall = tallField.getText().toString();
                String weight = weightField.getText().toString();

                //BMI를 계산한다. 체중(kg)/키(m) * 키(m) >> 키를 cm로 입력받았으므로 100으로 나누어 제곱한다.
                //Math.pow()는 넘겨받은 파라미터 값을 제곱해서 돌려준다.
                double bmi = Double.parseDouble(weight) / Math.pow(Double.parseDouble(tall) / 100, 2);

                // 결과 bmi를 resultLabel 에 보여준다.
                resultLabel.setText("키 : " + tall + ", 체중 : " + weight + ", BMI : " + bmi);
            }
        });
    }
}
