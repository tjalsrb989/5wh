package com.example.alarm_proto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void onClick(View v){

        Intent usrIntent = new Intent(this,UserSetting.class);
        Intent alarmIntent = new Intent(this,AlarmManagement.class);
        Intent intent = new Intent(this, DestinationList.class);
        switch(v.getId()){
            case R.id.button2:
                startActivity(alarmIntent);
                break;
            case R.id.button3:
                startActivity(intent);
                break;
            case R.id.imageButton:
                startActivity(usrIntent);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}