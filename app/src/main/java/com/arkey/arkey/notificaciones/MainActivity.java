package com.arkey.arkey.notificaciones;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    //metodo que se le asignara a un boton para mostrar la notificación.
    public void notificar(View v){

        // Se crea el Intent, que dice a donde se va a dirigir el usuario despues de dar click en la notificacion.
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        // Sonido que tendra la notificacion, en este caso se ha utilizado el sonido, que se ha definido en el telefono
        // para las notificaciones.
        Uri sonido = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        // Se crea el cuerpo de la notifiacion, con sus respectivos parametros.
        NotificationCompat.Builder notificacion = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)  //Icono de la notificación.
                .setContentTitle("Notificacion")    // Titulo de la notificación.
                .setContentText("estas es una notificacion")    // Texto que contendra la notificación.
                .setSound(sonido)   //Sonido de la notificación, definido anteriormente.
                .setContentIntent(pendingIntent) //Hacia donde nos llevara la notificación.
                .setAutoCancel(true);

        // Por ultimos se utiliza el servicio de notificaciones para mostrar la notificacion.
        // notificaion.build() regresa una notificacion con el cuerpo anteriormente definido.
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notificacion.build());
    }
}
