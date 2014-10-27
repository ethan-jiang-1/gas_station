package com.example.ethan.gas_station;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Activity_SlideTwo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_two);
        associateButtons();
    }

    private void associateButtons() {
        Button btnRight = (Button) findViewById(R.id.bt_slide_right);
        btnRight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Do something here
                Log.d("Activity_SlideOne", "onClick right button");
                Intent intent = new Intent(Activity_SlideTwo.this, Activity_SlideThree.class);
                Bundle bndlanimation = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation_l2r_old, R.anim.animation_l2r_new).toBundle();
                startActivity(intent, bndlanimation);
                //startActivity(intent);
            }

        });

        Button btnLeft = (Button) findViewById(R.id.bt_slide_left);
        btnLeft.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Do something here
                Log.d("Activity_SlideOne", "onClick left button");
                Intent intent = new Intent(Activity_SlideTwo.this, Activity_SlideOne.class);
                Bundle bndlanimation = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation_r2l_new, R.anim.animation_r2l_old).toBundle();
                startActivity(intent, bndlanimation);
                //startActivity(intent);
            }

        });
    }
        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_slide_two, menu);
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
