package com.example.alarm_proto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AlarmManagement extends AppCompatActivity {

    public void onClickAlarm(View v){

        Intent aconfigIntent = new Intent(this,AlarmConfig.class);

        switch(v.getId()){
            case R.id.alarm_add:
                startActivity(aconfigIntent);
                break;
            case R.id.alarmmng_back:
                this.onBackPressed();
                break;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_management);
    }
}