package com.example.riiss.sommarspelappen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tx=(TextView) findViewById(R.id.textview5);

        Date today = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd, HH:mm");
        String folderName = formatter.format(today);
        tx.setText(folderName);

    }



    public  void easybuttonpress(View v){

        Intent intent= new Intent(this,EasyActivity.class);
        startActivity(intent);

    }

    public  void normalbuttonpress(View v){

        Intent intent= new Intent(this,NormalActivity.class);
        startActivity(intent);

    }


    public  void hardbuttonpress(View v){

        Intent intent= new Intent(this,HardActivity.class);
        startActivity(intent);

    }


}
