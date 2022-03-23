package com.abed.recyclerviewassignment;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    RecyclerView recyclerView;
    public static final String CHANNEL_ID="channel_id";

    static ArrayList<Data> data = new ArrayList<>();
//    Data datas;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.RecyclerView);




        ArrayList<Data>data =new ArrayList<>();

        data.add(new Data("dfsdfs","09176"));
        data.add(new Data("dfsdfs","37986"));
        data.add(new Data("dfsdfs","58758"));
        data.add(new Data("dfsdfs","0034343"));
        data.add(new Data("dfsdfs","5345"));
        data.add(new Data("dfsdfs","0000"));

        RecyclerAdapter adapter =new RecyclerAdapter(MainActivity.this, data, new OnClickListener() {
            @Override
            public void OnClick(Data data) {
                ShowNotification(data.name,data.phone);
            }
        });

        recyclerView.setAdapter(adapter);
    }

    public void ShowNotification(String name,String num){
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(getApplicationContext(),0,intent,0);

        NotificationCompat.Builder noBuilder=new NotificationCompat.Builder(MainActivity.this,CHANNEL_ID);
        noBuilder.setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(name)
                .setContentIntent(pendingIntent)


                .setContentText(num);

        NotificationManagerCompat notificationManagerCompat=NotificationManagerCompat.from(getApplicationContext());

        NotificationManager notificationManager = (NotificationManager) getSystemService(getApplicationContext().NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {



            NotificationChannel notificationChannel=
                    new NotificationChannel(CHANNEL_ID,"Name", NotificationManager.IMPORTANCE_DEFAULT);

            notificationManager.createNotificationChannel(notificationChannel);


        }

        notificationManagerCompat.notify(15,noBuilder.build());



    }

}