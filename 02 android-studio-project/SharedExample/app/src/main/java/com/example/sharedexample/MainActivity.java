package com.example.sharedexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_save;
    String shared = "file";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // *초기*
        // EditText, SharedPreferences
        et_save = (EditText)findViewById(R.id.et_save);
        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);

        // *불러오기*
        String value = sharedPreferences.getString("won", "");
        et_save.setText(value);
        
    }

    // ctrl + o 를 눌러 onDestroy를 생성. 
    // 앱을 종료시켰을 때 (이 Activity가 파괴되었을 때) 수정을 해줄 수 있는 것
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // *저장*
        
        // 1. SharedPreferences와 Editor 연결
        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        
        // 2. 안드로이드 키보드에서 입력한 것을 value에 저장
        String value = et_save.getText().toString();
        
        // 3. won이라는 이름으로 value를 저장
        editor.putString("won", value);
        
        // 3. 진짜 저장
        editor.commit();
    }
}