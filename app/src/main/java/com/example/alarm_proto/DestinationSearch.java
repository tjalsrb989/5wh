package com.example.alarm_proto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DestinationSearch extends AppCompatActivity {
    public void onClick(View v){

        switch(v.getId()){
            case R.id.go_back_button:
                this.onBackPressed();
                break;

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination_search);
    }
}