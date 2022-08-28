package com.ulp.tp1_enzomiranda;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;
import android.content.Context;

public class ConexionWifi extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("salida","Cambiando conexión wifi, se llamará al numero solicitado");
        Toast.makeText(context, "Conexión wifi cambiada, se llamará a 2664553747", Toast.LENGTH_SHORT).show();
        Intent intentCall = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "2664553747"));
        context.startActivity(intentCall);
    }
}