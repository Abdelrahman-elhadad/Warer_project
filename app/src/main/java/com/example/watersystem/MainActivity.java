package com.example.watersystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.watersystem.db.AppDatabase;
import com.example.watersystem.db.table.UserWater;
import com.example.watersystem.model.Day;
import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edt_count;
    Spinner sp_day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView iv_plus = findViewById(R.id.iv_plus);
        ImageView iv_minus = findViewById(R.id.iv_minus);
        edt_count = findViewById(R.id.edt_count);
        sp_day = findViewById(R.id.sp_day);

        List<Day> days = new ArrayList<>();

        for (int i = 0; i < 7; i++) {

            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, i);

            Day day = new Day();
            day.setDate(new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(calendar.getTime()));
            day.setDay(calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, new Locale("ar")));

            days.add(day);
        }

        ArrayAdapter<Day> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, days);
        sp_day.setAdapter(arrayAdapter);



        iv_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int count=Integer.parseInt(edt_count.getEditableText().toString());
                count++;
                edt_count.setText(count+"");

            }
        });

    }

    public void search(View view) {

        Intent intent = new Intent(MainActivity.this, SearchActivity.class);
        startActivity(intent);
    }

    public void show(View view) {

        Intent intent = new Intent(MainActivity.this, ShowActivity.class);
        startActivity(intent);
    }

    public void add(View view) {


        final int count = Integer.parseInt(edt_count.getEditableText().toString());
        final Day day = (Day) sp_day.getSelectedItem();
        new Thread(new Runnable() {
            @Override
            public void run() {


                AppDatabase appDatabase = AppDatabase.newInstance(MainActivity.this);
                List<UserWater> userWaters = appDatabase.userWaterDao().getDate(day.getDate());
                if (userWaters != null && !userWaters.isEmpty()) {

                    UserWater userWater = userWaters.get(0);
                    userWater.setCount(userWater.getCount() + count);
                    appDatabase.userWaterDao().update(userWater);

                } else {
                    UserWater userWater = new UserWater();
                    userWater.setCount(count);
                    userWater.setDay(day.getDay());
                    userWater.setDate(day.getDate());
                    appDatabase.userWaterDao().insertAll(userWater);
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Snackbar.make(sp_day, "تمت الاضافة بنجاح", Snackbar.LENGTH_SHORT).show();
                    }
                });
            }
        }).start();

    }
}