package com.example.alarm_proto;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class UserSetting extends AppCompatActivity {

    public void onClick(View v) {


        EditText t_et = (EditText) findViewById(R.id.time_edit);

        String user_time = t_et.getText().toString();
        final int[] pre_time = new int[1];
        pre_time[0] = Integer.parseInt(user_time);


        switch(v.getId()){
            case R.id.go_back_button:
                if ( t_et.getText().toString().length() == 0 ) {
                    this.onBackPressed();
                    break;
                }
                else {
                    Intent intent = new Intent(this, AlarmConfig.class);
                    intent. putExtra("준비 시간", pre_time[0]);
                    this.onBackPressed();
                    break;
                }
        }
        RadioButton r_btnSLOW, r_btnNORMAL, r_btnFAST;//라디오 버튼
        RadioGroup radioGroup;
        View.OnClickListener radioButtonClickListener = null;

        r_btnSLOW = (RadioButton) findViewById(R.id.moving_speed_slow);
        r_btnNORMAL = (RadioButton) findViewById(R.id.moving_speed_normal);
        r_btnFAST = (RadioButton) findViewById(R.id.moving_speed_fast);

            r_btnSLOW.setOnClickListener(radioButtonClickListener);
            r_btnNORMAL.setOnClickListener(radioButtonClickListener);
            r_btnFAST.setOnClickListener(radioButtonClickListener);

            radioGroup = (RadioGroup) findViewById(R.id.RadioGroup);
            RadioGroup.OnCheckedChangeListener radioGroupButtonChangeListener = null;
            radioGroup.setOnCheckedChangeListener(radioGroupButtonChangeListener);

    RadioGroup.OnCheckedChangeListener RadioGroupButtonChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
            if (i == R.id.moving_speed_slow) {
                pre_time[0] = pre_time[0] +5;
            }
            else if (i == R.id.moving_speed_normal) {
                pre_time[0]=pre_time[0];
            }
            else if (i == R.id.moving_speed_fast) {
                pre_time[0]=pre_time[0]-5;
            }

        }
    };
};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_setting);

        



    }
}
