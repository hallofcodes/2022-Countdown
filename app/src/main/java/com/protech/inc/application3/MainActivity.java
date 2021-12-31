package com.protech.inc.application3;
 
import android.app.Activity;
import android.os.Bundle;
import java.util.Timer;
import android.os.CountDownTimer;
import java.util.TimerTask;
import android.widget.TextView;
import java.util.Date;
import java.util.concurrent.Future;

public class MainActivity extends Activity { 
     private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.activitymainTextView1);
       
        Date end = new Date("01/01/2022 00:00:00");
        Date now = new Date();
        long getEnd = end.getTime();
        long getNow =  now.getTime();
        long getSeconds = 1000;
        long getMinute = getSeconds * 60;
        long getHour = getMinute * 60;
        long getDay = getHour * 24;
        long distance = getEnd - getNow;
        
        long days = (long)Math.floor(distance / getDay);
        long hours = (long)Math.floor((distance % getDay) / getHour);
        long minutes = (long) Math.floor((distance % getHour) / getMinute);
        long seconds = (long)Math.floor((distance % getMinute) / getSeconds);

        
        
//        Date date = new Date("");
//        int yh = date.getYear();
//        int time =  (int)date.getTime();
//        int f =  time - yh;
//        int  day = (int)Math.floor(f/(1000*60*60*24));
//        int  hour = (int)Math.floor((f % (1000*60*60*24)) / (1000*60*60));
//        int minute = (int)Math.floor((f % (1000*60*60)) / (1000*60));
//        int seconds = (int)Math.floor((f % (1000*60)) / (1000));
//        
         countDown(days,hours,minutes,seconds);
        
        
    }
    
   public void countDown(final long day,final long hours, final long minutes, final long seconds){
    Timer timer = new Timer();
    TimerTask timertask;
    
    
    timertask = new TimerTask(){
           long getseconds = seconds;
           long getMinutes = minutes;
           long getHours = hours;
           long getDay = day;
           
        public void run(){
            
            runOnUiThread(new Runnable(){
               
                public void run(){
                    
                    
                    getseconds--;
                    if(getseconds < 0){
                       getseconds = 59;
                       getMinutes--;
                       if(getMinutes < 0){
                           getMinutes = 59;
                           getHours--;
                           if(getHours < 0){
                               getHours = 23;
                               getDay--;
                               
                               
                               if(getDay < 0){
                                   
                                   if(getHours < 0){
                                       getHours = 0;
                                       
                                       if(getMinutes < 0){
                                           
                                           getMinutes = 0;
                                           
                                           if(getseconds < 0){
                                               getseconds = 0;
                                           }
                                       }
                                   }
                                   
                               }
                           }
                           
                       }
                        
                        
                    }
                    String total = String.valueOf(getDay).concat(":").concat(String.valueOf(getHours)).concat(":").concat(String.valueOf(getMinutes)).concat(":").concat(String.valueOf(getseconds));
                    txt.setText(total);
                }
                
                
            });
            
        }
        
    };
    timer.scheduleAtFixedRate(timertask,1000,1000);
       
   }
	
} 
/*don't forget to subscribe my YouTube channel for more Tutorial and mod*/
/*
https://youtube.com/channel/UC_lCMHEhEOFYgJL6fg1ZzQA */
