package com.example.timetablesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView myListView;

    public void generateTimesTable(int timesTableNumber){

        ArrayList<String> timesTableContent = new ArrayList<>();

        for(int j=1;j<=100;j++){
            timesTableContent.add(Integer.toString(j * timesTableNumber));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, timesTableContent);
        myListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myListView = (ListView) findViewById(R.id.myListView);
        final SeekBar mySeekBar = (SeekBar) findViewById(R.id.seekBar);

        int max = 20;
        int startPos = 1;

        mySeekBar.setMax(max);
        mySeekBar.setProgress(startPos);

        generateTimesTable(startPos);

        mySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                int min = 1;
                int timesTableNumber;

                if(i < min){

                    timesTableNumber = min;
                    mySeekBar.setProgress(min);

                }else{
                    timesTableNumber = i;
                }

                Log.i("Seekbar progress", Integer.toString(timesTableNumber));
                Toast.makeText(MainActivity.this, "Showing table of: " + Integer.toString(timesTableNumber), Toast.LENGTH_SHORT).show();

                generateTimesTable(timesTableNumber);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}