package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_id;
    Button btn_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        et_id = findViewById(R.id.et_id); // 특정 아이디를 속성에 부여를 해라?
        btn_test = findViewById((R.id.btn_test));

        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_id.getText().toString()=="이원영") {
                    et_id.setText("내 이름");
                }
                else if (et_id.getText().toString()=="32193337") {
                    et_id.setText("내 학번");
                }
            }
        });

    }
}