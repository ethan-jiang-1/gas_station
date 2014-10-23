package com.example.ethan.gas_station;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.List;


public class Activity_Wifi extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);

        TextView textView = (TextView)findViewById(R.id.tv_wifi_log);
        textView.setMovementMethod(new ScrollingMovementMethod());

        WifiWalker ww = new WifiWalker();
        String msg = ww.getInfo();
        logMsg(msg);

    }

    public void logMsg(String str) {
        TextView tv = (TextView)findViewById(R.id.tv_wifi_log);
        tv.append(str);
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


    public class WifiWalker
    {
        public WifiWalker() {

        }

        public String getInfo() {
            String str = new String();

            WifiManager wfm = (WifiManager) getSystemService(Context.WIFI_SERVICE);
            if (wfm == null) {
                str = "warning: no wifi manager\n";
                return str;
            }

            List<WifiConfiguration> wcs = wfm.getConfiguredNetworks();
            if (wcs == null) {
                str = "warning: no list of wifi configuration\n";
                return str;
            }

            for(WifiConfiguration wc : wcs) {
                str += "SSID" + wc.SSID + "\n";
                str += "preSharedKey" + wc.preSharedKey + "\n";

                for (int i=0; i<4; i++ ) {
                    str += "wepkey[" + i + "]" + wc.wepKeys[i] + "\n";
                }
                str += "----------------\n";
            }

            return str;
        }


    }

}
