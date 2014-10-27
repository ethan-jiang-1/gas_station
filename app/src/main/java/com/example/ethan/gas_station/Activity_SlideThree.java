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


public class Activity_SlideThree extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_three);
        associateButtons();
    }

    private void associateButtons() {
        Button btnLeft = (Button) findViewById(R.id.bt_slide_left);
        btnLeft.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Do something here
                Log.d("Activity_SlideThree", "onClick left button");
                Intent intent = new Intent(Activity_SlideThree.this, Activity_SlideTwo.class);
                Bundle bndlanimation = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation_r2l_new, R.anim.animation_r2l_old).toBundle();
                startActivity(intent, bndlanimation);
                //startActivity(intent);
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_slide_three, menu);
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
