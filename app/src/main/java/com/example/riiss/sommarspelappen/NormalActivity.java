package com.example.riiss.sommarspelappen;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class NormalActivity extends AppCompatActivity {

    int score=0;
    final int[] images = { R.drawable.skjuttmatt,R.drawable.laptop,R.drawable.adapter};
    Random generator = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);

        AlertDialog.Builder builder = new AlertDialog.Builder(NormalActivity.this);
        builder.setTitle("Börja spelet!");
        builder.setMessage("Tryck på fortsätt för att starta spelet");
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

        ImageView imageView=(ImageView) findViewById(R.id.imageView4);

        imageView.setImageResource(images[generator.nextInt(images.length)]);

        score=0;
    }

    public void nextbutton(View v){

        EditText editText=(EditText)findViewById(R.id.editText);
        TextView textView=(TextView)findViewById(R.id.textView);
        ImageView imageView = (ImageView) findViewById(R.id.imageView4);
        textView.setText("");


        if(editText.getText().toString().trim().length()==0){

            AlertDialog.Builder builder = new AlertDialog.Builder(NormalActivity.this);
            builder.setTitle("Text rutan tom");
            builder.setMessage("Textrutn är tom. Var god och fyll i");
            builder.setNegativeButton("Ok" , null);
            builder.create();
            builder.show();

        }
        else {

            editText.setText("");
            imageView.setImageResource(images[generator.nextInt(images.length)]);
            Button button=(Button)findViewById(R.id.button1);
            button.setVisibility(View.GONE);
        }

    }

    public void quessbutton(View v){

        ImageView imageView=(ImageView) findViewById(R.id.imageView4);
        EditText editText=(EditText)findViewById(R.id.editText);
        TextView textView=(TextView)findViewById(R.id.textView);

        String text=editText.getText().toString();

        if(imageView.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.laptop).getConstantState() && text.equals("laptop") ){

            repeatmethod(v);
        }
        else if(imageView.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.skjuttmatt).getConstantState() && text.equals("skjutmått") ){

            repeatmethod(v);
        }
        else if(imageView.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.adapter).getConstantState() && text.equals("adapter") ){

            repeatmethod(v);
        }
        else {
            textView.setTextColor(Color.RED);
            textView.setText("Fel");
        }
    }

    public void repeatmethod(View v){

        TextView textView=(TextView)findViewById(R.id.textView);
        TextView textView2=(TextView)findViewById(R.id.textView4);
        Button button=(Button)findViewById(R.id.button1);
        button.setVisibility(View.VISIBLE);

        textView.setTextColor(Color.GREEN);
        textView.setText("Rätt!");
        score++;
        textView2.setText("Poäng " + score);

    }
}
