# 01 TextView, EditText, Button

## 1. 요소들 배열 방향 정하기

`android:orientation = "horizontal"` - 가로로 배열

`android:orientation = "vertical"` - 세로로 배열

## 2. `<TextView> />`

![01%20TextView,%20EditText,%20Button%20a34f7d54a41a41709392717c9366c5f4/Untitled.png](01%20TextView,%20EditText,%20Button%20a34f7d54a41a41709392717c9366c5f4/Untitled.png)

```xml
   <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text=" id: "/>
```

## 3. `<EditText> />`

![01%20TextView,%20EditText,%20Button%20a34f7d54a41a41709392717c9366c5f4/Untitled%201.png](01%20TextView,%20EditText,%20Button%20a34f7d54a41a41709392717c9366c5f4/Untitled%201.png)

```xml
   <EditText
       android:id="@+id/et_id"
       android:layout_width="250dp"
       android:layout_height="wrap_content"
       android:hint="아이디를 입력하세요..."/
```

## 4. `<Button> />`

![01%20TextView,%20EditText,%20Button%20a34f7d54a41a41709392717c9366c5f4/Untitled%202.png](01%20TextView,%20EditText,%20Button%20a34f7d54a41a41709392717c9366c5f4/Untitled%202.png)

```xml
    <Button
        android:id="@+id/btn_test"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="버튼"/>
```

```java
btn_test.**setOnClickListener**(**new View.OnClickListener()** {
            @Override
            public void **onClick**(View v) {
                et_id.setText("이원영");
            }
        });
```

# activity_main.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="horizontal"
    tools:context=".MainActivity">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text=" id: "/>

   <EditText
       android:id="@+id/et_id"
       android:layout_width="250dp"
       android:layout_height="wrap_content"
       android:hint="아이디를 입력하세요..."/>

    <Button
        android:id="@+id/btn_test"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="버튼"/>

</LinearLayout>
```

# MainActivity.java

```java
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

        et_id = findViewById(R.id.et_id); // 특정 아이디를 속성에 부여를 해라
        btn_test = findViewById((R.id.btn_test));

        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_id.setText("이원영");
            }
        });

    }
}
```