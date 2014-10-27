package com.example.ethan.gas_station;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Activity_Main extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Activity_Main","onCreate");

        associateButtons();
    }

    private void associateButtons(){
        Button btnWifi = (Button)findViewById(R.id.bt_main_wifi);
        btnWifi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Do something here
                Log.d("Activity_Main", "onClick Wifi button");
                Intent intent = new Intent(Activity_Main.this, Activity_Wifi.class);
                startActivity(intent);
            }

        });


        Button btnHtml = (Button)findViewById(R.id.bt_main_html);
        btnHtml.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Do something here
                Log.d("Activity_Main","onClick html button");
                Intent intent = new Intent(Activity_Main.this, Activity_Html.class);
                startActivity(intent);
            }
        });

        Button btnSlide = (Button)findViewById(R.id.bt_main_slide);
        btnSlide.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            public void onClick(View v) {
                //Do something here
                Log.d("Activity_Main","onClick Slide button");
                Intent intent = new Intent(Activity_Main.this, Activity_SlideOne.class);

                Bundle bndlanimation = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation_l2r_old, R.anim.animation_l2r_new).toBundle();
                startActivity(intent, bndlanimation);

                //startActivity(intent);
            }
        });
    }

    public void sendMessage(View view) {
        Log.d("Activity_Main","sendMessage");
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
