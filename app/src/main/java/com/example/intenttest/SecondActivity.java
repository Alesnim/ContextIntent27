package com.example.intenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle data = getIntent().getExtras();
        String message = data.getString("message");
        Intent answer = new Intent();
        answer.putExtra("message", message);
        setResult(RESULT_OK, answer);
        finish();
    }


}
