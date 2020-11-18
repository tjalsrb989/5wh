package com.example.alarm_proto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class AlarmConfig extends AppCompatActivity {
    AlarmManager alarm_manager; //알람 메니저
    PendingIntent pendingIntent;

    public void onClickAlarmConfig(View v){
        //알람 메니저 설정
        alarm_manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        EditText et = (EditText)findViewById(R.id.recom_input);
        Intent routeIntent = new Intent(this,RouteConfig.class);
        //알람 리시버 인텐트 생성
        final Intent al_intent = new Intent(this, Alarm_Receiver.class);
        //캘린더 객체 생성
        final Calendar calendar = Calendar.getInstance();
        switch(v.getId()){
            case R.id.route_sel: startActivity(routeIntent); //경로 선택 버튼
            break;
            case R.id.alarmcon_back: this.onBackPressed(); //뒤로가기
            break;
            case R.id.config_finish: //알람 설정 완료 버튼
            //리시버에 string값 넘겨주기

                String time = et.getText().toString();

                if ( et.getText().toString().length() == 0 ) {

                    Toast myToast = Toast.makeText(this.getApplicationContext(),"input time first", Toast.LENGTH_SHORT);
                    myToast.show();
                    break;

                } else {
                    String[] arr= time.split(":");
                    int hour, minute;
                    hour = Integer.parseInt(arr[0]);
                    minute = Integer.parseInt(arr[1]);
                    calendar.setTimeInMillis(System.currentTimeMillis());
                    calendar.set(Calendar.HOUR_OF_DAY, hour);
                    calendar.set(Calendar.MINUTE,minute);
                    calendar.set(Calendar.SECOND, 0);

                    Toast.makeText(this,"Alarm 예정 " + hour + "시 " + minute + "분",Toast.LENGTH_SHORT).show();
                    //이미 지나간 시간 지정이면 다음날로 지정
                    if (calendar.before(Calendar.getInstance())) {
                        calendar.add(Calendar.DATE, 1);
                    }
                }

                // reveiver에 string 값 넘겨주기
                al_intent.putExtra("state","alarm on");

                pendingIntent = PendingIntent.getBroadcast(this,0,al_intent,PendingIntent.FLAG_UPDATE_CURRENT);
                //알람 세팅
                alarm_manager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_config);



    }
}