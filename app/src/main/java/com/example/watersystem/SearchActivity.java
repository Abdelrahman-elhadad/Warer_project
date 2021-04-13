package com.example.watersystem;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SearchActivity extends AppCompatActivity {
    String url = "https://www.google.ps/search?q=";

    EditText edtSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page3);
        edtSearch = findViewById(R.id.editTextTextPersonName);

    }

    public void search(View view) {

        url = url + "" + edtSearch.getEditableText().toString();
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }

    public void show(View view) {
        Intent intent = new Intent(this, ShowActivity.class);
        startActivity(intent);
    }

    public void mainView(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
