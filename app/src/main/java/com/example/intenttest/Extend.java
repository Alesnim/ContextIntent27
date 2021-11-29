package com.example.intenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Extend extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extend);
        Bundle extras = getIntent().getExtras();
        TextView textView = findViewById(R.id.tv_res_extend);
        textView.setText(extras.getString("message"));
    }
}
