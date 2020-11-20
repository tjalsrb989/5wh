package com.example.alarm_proto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;

import java.security.MessageDigest;

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
        getAppKeyHash();
    }

    private void getAppKeyHash() {
        try {
            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md;
                md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String something = new String(Base64.encode(md.digest(), 0));
                Log.e("Hash key", something);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            Log.e("name not found", e.toString());
        }
    }

}