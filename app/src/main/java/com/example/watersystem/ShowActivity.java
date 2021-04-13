package com.example.watersystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.watersystem.adapter.AdapterAllData;
import com.example.watersystem.db.AppDatabase;
import com.example.watersystem.db.table.UserWater;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        RecyclerView rv_data = findViewById(R.id.rv_data);
        rv_data.setLayoutManager(new LinearLayoutManager(ShowActivity.this));

        new Thread(new Runnable() {
            @Override
            public void run() {


                AppDatabase appDatabase = AppDatabase.newInstance(ShowActivity.this);
                List<UserWater> userWaters = appDatabase.userWaterDao().getAll();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        AdapterAllData adapterAllData = new AdapterAllData(userWaters);
                        rv_data.setAdapter(adapterAllData);

                    }
                });

            }
        }).start();
    }


    public void search(View view) {

        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }

    public void mainView(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
