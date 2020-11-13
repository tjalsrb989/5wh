package com.example.alarm_proto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AlarmConfig extends AppCompatActivity {

    public void onClickAlarmConfig(View v){
        Intent routeIntent = new Intent(this,RouteConfig.class);

        switch(v.getId()){
            case R.id.button6: startActivity(routeIntent);
            break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_config);
    }
}