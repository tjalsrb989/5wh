package com.example.alarm_proto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AddDestination extends AppCompatActivity {

    public void onClick(View v){
        Intent desSrcIntent = new Intent(this,DestinationSearch.class);
        switch(v.getId()){
            case R.id.go_back_button:
                this.onBackPressed();
                break;
            case R.id.add_destination_button:
                startActivity(desSrcIntent);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_destination);
    }
}