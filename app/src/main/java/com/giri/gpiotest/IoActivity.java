package com.giri.gpiotest;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;


public class IoActivity extends AppCompatActivity {

    String gpioValue = "";

    String defString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_io);

        getGpio39();

        // 输出
        Toast.makeText(this, gpioValue, Toast.LENGTH_SHORT).show();

        // 返回主界面
        finish();
    }

    //读GPIO
    public void getGpio39() {
        // 定义路径
        String gpioPath = "/sys/class/gpio/gpio39/value";

        // 创建接收缓冲区
        char[] buffer = new char[2048];

        try {
            @SuppressWarnings("resource")
            FileReader fileReader = new FileReader(gpioPath);
            BufferedReader reader = new BufferedReader(fileReader);
            reader.read(buffer);

            gpioValue = buffer[0] + "";
            reader.close();
            fileReader.close();
        } catch (IOException e) {
            Log.d("error", "cat GPIO error");
            e.printStackTrace();
        }

    }
}
