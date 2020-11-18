package com.example.alarm_proto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RouteConfig extends AppCompatActivity {

    public void onClickRoute(View v){
        Intent rSelectIntent = new Intent(this,RouteSelect.class);

        switch(v.getId())
        {
            case R.id.imageButton6:
                startActivity(rSelectIntent);
                break;
            case R.id.imageButton4:
                this.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_config);
    }
}