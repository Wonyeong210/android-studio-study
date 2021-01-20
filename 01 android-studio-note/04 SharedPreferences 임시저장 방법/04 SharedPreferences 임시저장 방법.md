# 04 SharedPreferences 임시저장 방법

임시저장을 할 때 자주 쓰이는 방법이다. 어플이 꺼져도 다시 키면 사용자가 지정한 것이 저장된다. 어플이 꺼지면 사라지는 데 어플이 꺼져도 지속되기를 원하면 데이터 베이스 활용을 해야한다.

acitivity_main.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <EditText
        android:id="@+id/et_save"
        android:layout_width="100dp"
        android:layout_height="wrap_content"/>

</LinearLayout>
```

MainActivity.java

```java
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
```