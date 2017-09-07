package com.example.riiss.sommarspelappen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ScoreScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_screen);

        TextView textView=(TextView)findViewById(R.id.score);

        Intent intent = getIntent();

        int score= intent.getIntExtra("SCORE",0);

        textView.setText(String.valueOf(score));
    }






 public void homepage(View v){

    Intent intent= new Intent(this,MainActivity.class);
    startActivity(intent);

}





}
