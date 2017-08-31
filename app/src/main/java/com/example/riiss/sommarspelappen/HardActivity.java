package com.example.riiss.sommarspelappen;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class HardActivity extends AppCompatActivity {

    int score=0;
    int rightanwser=0;
    ArrayList<Integer> image=new ArrayList<Integer>();
    ArrayList<String> anwser=new ArrayList<String>();
    Random pos=new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard2);

        AlertDialog.Builder builder = new AlertDialog.Builder(HardActivity.this);
        builder.setTitle("Börja spelet!");
        builder.setMessage("Tryck på fortsätt för att starta spelet. Efter du har skrivi in svaret och det är rätt så" +
                "dyker det en kanpp där du kan fortsätta till nästa bild.");
        builder.setPositiveButton("Tillbacka", new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialog, int press){

                startActivity(new Intent(getBaseContext(),MainActivity.class));

            }
        });

        builder.setNegativeButton("Fortsätt" , null);
        builder.create();
        builder.show();

        score=0;

        Button button=(Button)findViewById(R.id.button1);
        button.setVisibility(View.GONE);

        image.add(R.drawable.frekvens);
        anwser.add("frekvens");
        image.add(R.drawable.kirurg);
        anwser.add("kirurg");
        image.add(R.drawable.kongress);
        anwser.add("kongress");

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
        Button button=(Button)findViewById(R.id.button1);

        Log.d("*"+(editText.getText().toString())+"*", "-"+anwser.get(rightanwser)+"-");


        if(editText.getText().toString().equals(anwser.get(rightanwser))){

            Log.d("rätt ", "rätt");
            button.setVisibility(View.VISIBLE);

            textView.setTextColor(Color.GREEN);
            textView.setText("Rätt!");
            score++;
            textView2.setText("Poäng " + score);


            image.remove(rightanwser);
            anwser.remove(rightanwser);

            if (image.size()==0){

                Intent intent= new Intent(this,ScoreScreen.class);
                startActivity(intent);
            }


        }

        else {

            textView.setTextColor(Color.RED);
            textView.setText("Fel");
        }
    }

}
