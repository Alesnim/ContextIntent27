package com.example.intenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String ACTION;

    static {
        ACTION = "com.example.intenttest.SHOW_EXTEND_ACTIVITY";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClick(View view){
        Intent intent = new Intent(ACTION);
        EditText eText = findViewById(R.id.editText);
        intent.putExtra("message", eText.getText().toString());
        startActivity(intent);
    }

    public  void sendMessage(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        EditText eText = findViewById(R.id.editText);
        intent.putExtra("message", eText.getText().toString());
        startActivityForResult(intent,1);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        TextView editText = findViewById(R.id.textView);
        if (requestCode == 1) {
            editText.setText(data.getStringExtra("message"));
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }


    }
}
