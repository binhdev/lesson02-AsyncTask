package com.example.lesson01_asynctask;

import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int a[];
    final int SIZE = 100;

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textView = findViewById(R.id.text);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayGeneration(SIZE);
                new MyAsyncTask().execute();
            }
        });
    }

    void arrayGeneration(int size){
        a = new int[size];
        Random random = new Random();
        for(int i=0; i < size; i++){
            a[i] = random.nextInt(100);
        }
    }

    class MyAsyncTask extends AsyncTask<Void, Void, Integer>{

        @Override
        protected Integer doInBackground(Void... voids) {
            int tong = 0;
            for(int i=0; i < SIZE; i++){
                tong += a[i];
            }
            return tong;
        }

        @Override
        protected void onPostExecute(Integer tong) {
            textView.setText("Tong: " + tong);
        }
    }
}