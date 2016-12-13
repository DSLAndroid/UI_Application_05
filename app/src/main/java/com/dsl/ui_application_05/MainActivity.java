package com.dsl.ui_application_05;

import android.app.Activity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * 功能：安卓时间控件
 *
 * 作者：单胜凌
 * 时间：2016.12.13
 */
public class MainActivity extends Activity {

    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        TimePicker timepicker = (TimePicker)findViewById(R.id.timePicker);
        DatePicker datePicker = (DatePicker)findViewById(R.id.datePicker);
        timepicker.setIs24HourView(true);//设置24小时制
        Calendar calendar = Calendar.getInstance();//获取当前时间的对象
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DATE);
        hour = calendar.get(Calendar.HOUR);
        minute = calendar.get(Calendar.MINUTE);
        //为日期初始化并设置监听器
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                MainActivity.this.year = year;
                MainActivity.this.month= monthOfYear;
                MainActivity.this.day = dayOfMonth;
                MyToast(year,monthOfYear,dayOfMonth,hour,minute);

            }
        });
        timepicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                MainActivity.this.hour = hourOfDay;
                MainActivity.this.minute=minute;
                MyToast(year,month,day,hourOfDay,minute);
            }
        });

    }
    private void MyToast(int year,int month,int day,int hour,int minute)
    {
        String str=year+"年"+(month+1)+"月"+day+"日"+hour+":"+minute;
        Toast.makeText(this,str,Toast.LENGTH_LONG).show();
    }
}
