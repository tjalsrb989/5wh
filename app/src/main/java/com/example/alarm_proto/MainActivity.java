package com.example.alarm_proto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void onClick(View v){

        Intent usrIntent = new Intent(this,UserSetting.class);
        Intent alarmIntent = new Intent(this,AlarmManagement.class);
        Intent intent = new Intent(this, AddDestination.class);
        switch(v.getId()){
            case R.id.alarm_button:
                startActivity(alarmIntent);
                break;
            case R.id.destination_button:
                startActivity(intent);
                break;
            case R.id.setting_button:
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