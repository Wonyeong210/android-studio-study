package com.example.dialogexample;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_dialog;
    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_dialog = (Button)findViewById(R.id.btn_dialog);
        tv_result = (TextView)findViewById(R.id.tv_result);

        // 버튼을 누르면
        btn_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 다이얼로그
                AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);
                ad.setIcon(R.mipmap.ic_launcher);
                ad.setTitle("title");
                ad.setMessage("Question?");

                // EditText
                final EditText et = new EditText(MainActivity.this);
                ad.setView(et);

                // Positive Button
                ad.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String result = et.getText().toString();
                        tv_result.setText(result);
                        dialog.dismiss();
                    }
                });

                // NegativeButton
                ad.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                ad.show();

            }
        });
    }
}