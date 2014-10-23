package com.example.ethan.gas_station;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.List;

import static android.view.View.*;


public class Activity_Wifi extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);

        TextView textView = (TextView)findViewById(R.id.tv_wifi_log);
        textView.setMovementMethod(new ScrollingMovementMethod());

        associateButtons();
        updateLog();

    }

    public void associateButtons() {
        Button btnWifi = (Button)findViewById(R.id.btn_wifi_refresh);
        btnWifi.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Log.d("Activity_wifi", "OnClick Refresh Button");
                Activity_Wifi.this.updateLog();
            }

        });
    }

    public void logMsg(String str) {
        TextView tv = (TextView)findViewById(R.id.tv_wifi_log);
        tv.append(str);
    }

    public void clearMsg(){
        TextView tv = (TextView)findViewById(R.id.tv_wifi_log);
        tv.setText("");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_wifi, menu);
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

    public void updateLog() {
        WifiWalker ww = new WifiWalker();

        clearMsg();

        String msg;
        msg = ww.getWfInfo();
        msg += ww.getWcInfo();
        logMsg(msg);
    }


    public class WifiWalker
    {
        public WifiWalker() {

        }

        public String getWfInfo() {
            String str = new String();
            str =  "---WifiInfo---\n";

            WifiManager wfm = (WifiManager) getSystemService(Context.WIFI_SERVICE);
            if (wfm == null) {
                str += "No wifi manager Service\n";
                return str;
            }
            WifiInfo wi = wfm.getConnectionInfo();
            if (wi == null) {
                str += "No wifi connection info\n";
            }

            str += "current SSID" + wi.getSSID() + "\n";
            str += "wifi Info: " + wi.toString() + "\n";


            return str;
        }

        public String getWcInfo() {
            String str = new String();

            str = "---WifiConfiguration---\n";

            WifiManager wfm = (WifiManager) getSystemService(Context.WIFI_SERVICE);
            if (wfm == null) {
                str += "No wifi manager Service\n";
                return str;
            }

            List<WifiConfiguration> wcs = wfm.getConfiguredNetworks();
            if (wcs == null) {
                str += "No existing list of wifi configuration\n";
                return str;
            }

            int m= 1;
            for(WifiConfiguration wc : wcs) {
                str += "---config " + m++ + " :\n";
                str += "SSID" + wc.SSID + "\n";
                str += "preSharedKey" + wc.preSharedKey + "\n";

                for (int i=0; i<4; i++ ) {
                    str += "wepkey[" + i + "]" + wc.wepKeys[i] + "\n";
                }

            }

            return str;
        }


    }

}
