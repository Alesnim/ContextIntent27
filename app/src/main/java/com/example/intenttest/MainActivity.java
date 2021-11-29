package com.example.intenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String ACTION;
    Button b;

    static {
        ACTION = "com.example.intenttest.SHOW_EXTEND_ACTIVITY";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = findViewById(R.id.bt_hidden);

        b.setOnClickListener((v) -> callSms());


    }

    private void callSms() {
        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        sendIntent.setData(Uri.parse("sms:"));
        String tex = "test test";
        sendIntent.putExtra("sms_body", tex);
        startActivity(sendIntent);
    }



    // добавить метод вызывающий интент для камеры

    public void onClick(View view) {
        Intent intent = new Intent(ACTION);
        EditText eText = findViewById(R.id.et_input);
        intent.putExtra("message", eText.getText().toString());
        startActivity(intent);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        EditText eText = findViewById(R.id.et_input);
        intent.putExtra("message", eText.getText().toString());
        startActivityForResult(intent, 1);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        TextView editText = findViewById(R.id.tv_res);
        if (requestCode == 1) {
            editText.setText(data.getStringExtra("message"));
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }


    }
}
