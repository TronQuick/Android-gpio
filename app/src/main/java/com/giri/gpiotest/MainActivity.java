package com.giri.gpiotest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Buzzer bz = new Buzzer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bz.export(36);
        bz.export(39);
        bz.export(40);
        bz.gpio(36,"in",0);
        bz.gpio(39,"in",0);
        bz.gpio(40,"in",0);
    }

    // IO采集上传
    public void startIO(View view) {
        Intent intent = new Intent(this, IoActivity.class);
        startActivity(intent);
    }
}
