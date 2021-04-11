package com.example.watersystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void source(View view) {
        Intent intent = new Intent(MainActivity.this, Page2.class);
        startActivity(intent);

    }

    public void main(View view) {


    }

    public void Benefits(View view) {
        Intent intent = new Intent(MainActivity.this, Page3.class);
        startActivity(intent);

    }
}