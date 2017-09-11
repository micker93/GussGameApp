package com.example.riiss.sommarspelappen;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class NormalActivity extends AppCompatActivity {

    int score=0;
    int rightanwser=0;
    ArrayList<Integer> image=new ArrayList<Integer>();
    ArrayList<String> anwser=new ArrayList<String>();
    Random pos=new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);

        AlertDialog.Builder builder = new AlertDialog.Builder(NormalActivity.this);
        builder.setTitle("Börja spelet!");
        builder.setMessage("Tryck på börja för att starta spelet. Eller tillbacka för att komma till startsidan");
        builder.setPositiveButton("Tillbacka", new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialog, int press){

                startActivity(new Intent(getBaseContext(),MainActivity.class));


            }
        });

        builder.setNegativeButton("Fortsätt" , null);
        builder.create();
        builder.show();

        Button button=(Button)findViewById(R.id.button1);
        button.setVisibility(View.GONE);

        score=0;

        image.add(R.drawable.adapter);
        anwser.add("adapter");
        image.add(R.drawable.laptop);
        anwser.add("laptop");
        image.add(R.drawable.skjuttmatt);
        anwser.add("skjutmått");

        ImageView imageView=(ImageView) findViewById(R.id.imageView4);

        rightanwser=(pos.nextInt(anwser.size()));
        imageView.setImageResource(image.get(rightanwser));
    }

    public void nextbutton(View v){

        EditText editText = (EditText) findViewById(R.id.editText);
        TextView textView = (TextView) findViewById(R.id.textView);
        ImageView imageView = (ImageView) findViewById(R.id.imageView4);

        textView.setText("");
        editText.setText("");

        Button button = (Button) findViewById(R.id.button1);
        button.setVisibility(View.GONE);

        rightanwser = (pos.nextInt(anwser.size()));
        imageView.setImageResource(image.get(rightanwser));

    }

    public void quessbutton(View v){

        EditText editText=(EditText)findViewById(R.id.editText);
        TextView textView=(TextView)findViewById(R.id.textView);
        TextView textView2=(TextView)findViewById(R.id.textView4);
        TextView textView1=(TextView)findViewById(R.id.texttips);
        Button button=(Button)findViewById(R.id.button1);

        Log.d("*"+(editText.getText().toString())+"*", "-"+anwser.get(rightanwser)+"-");


        if(editText.getText().toString().equals(anwser.get(rightanwser))){

            Log.d("rätt ", "rätt");
            button.setVisibility(View.VISIBLE);

            textView.setTextColor(Color.GREEN);
            textView.setText("Rätt!");
            score++;
            textView2.setText("Poäng " + score);
            textView1.setText("");


            image.remove(rightanwser);
            anwser.remove(rightanwser);

            if (image.size()==0){

                Intent intent= new Intent(this,ScoreScreen.class);
                intent.putExtra("SCORE", score);
                startActivity(intent);
            }


        }

        else {

            textView.setTextColor(Color.RED);
            textView.setText("Fel");
            editText.setText("");

            switch (image.get(rightanwser)) {
                case R.drawable.adapter:
                    textView1.setText("Ledtråd: Anpassa en apparat till en annan appara");
                    break;
                case R.drawable.laptop:
                    textView1.setText("Ledtråd: bärbar dator");
                    break;
                case R.drawable.skjuttmatt:
                    textView1.setText("Ledtråd: Man mäter med");
                    break;
            }
        }

        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(this.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }
}
