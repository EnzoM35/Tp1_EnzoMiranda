package com.ulp.tp1_enzomiranda;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ConexionWifi cf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        solicitarPermiso();
    }

    @Override
    protected void onResume() {
        this.cf = new ConexionWifi();
        registerReceiver(this.cf, new IntentFilter("android.net.wifi.supplicant.CONNECTION_CHANGE"));
        super.onResume();
    }

    @Override
    protected void onPause() {
        unregisterReceiver(cf);
        super.onPause();
    }

    private void solicitarPermiso() {
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M
                && checkSelfPermission(Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE},1000);
        }
    }
}