package com.dm.helloproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = "MainActivity";
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.sendButton);
        button.setOnClickListener(this);
    }

    public void sendMessage(View button) {
        // open new activity
        Intent intent = new Intent(MainActivity.this, TextActivity.class);
        intent.putExtra("text", editText.getText().toString());
        startActivity(intent);
        Log.i(TAG, "sendMessage - " + editText.getText().toString());
    }

    @Override
    public void onClick(View button) {
        switch (button.getId()){
            case R.id.sendButton:
                sendMessage(button);
                break;
        }
    }
}