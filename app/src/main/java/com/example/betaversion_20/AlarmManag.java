package com.example.betaversion_20;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import java.util.Random;

public class AlarmManag extends BroadcastReceiver {

    Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onReceive(Context context, Intent intent) {
        Random random = new Random();
        int value = random.nextInt(3);

        NotificationChannel notificationChannel = new NotificationChannel("MyMusic", "Music",
                NotificationManager.IMPORTANCE_HIGH);

        NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(context, "MyMusic")
                .setChannelId("MyMusic")
                .setColor(Color.RED)
                .setContentTitle(Arrays.NOTIFICATION_TEXT[value])
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setSmallIcon(R.drawable.ic_launcher_background);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.createNotificationChannel(notificationChannel);
        notificationManager.notify(1238,nBuilder.build());

    }
    /*.setContentTitle("Не забудьте зайти к нам\uD83D\uDC7F❤\uD83D\uDC7F")*/
}
