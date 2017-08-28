package com.example.riiss.sommarspelappen;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class EasyActivity extends AppCompatActivity {

    int score=0;
    ArrayList<Integer> image=new ArrayList<Integer>();
    Random pos=new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy);

        AlertDialog.Builder builder = new AlertDialog.Builder(EasyActivity.this);
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

        image.add(R.drawable.frekvens);
        image.add(R.drawable.kirurg);
        image.add(R.drawable.kongress);

        ImageView imageView=(ImageView) findViewById(R.id.imageView4);
        imageView.setImageResource(image.get(pos.nextInt(image.size())));

        score=0;


    }

    public void nextbutton(View v){

        EditText editText=(EditText)findViewById(R.id.editText);
        TextView textView=(TextView)findViewById(R.id.textView);
        ImageView imageView = (ImageView) findViewById(R.id.imageView4);
        textView.setText("");


        if(editText.getText().toString().trim().length()==0){

            AlertDialog.Builder builder = new AlertDialog.Builder(EasyActivity.this);
            builder.setTitle("Text rutan tom");
            builder.setMessage("Textrutn är tom. Var god och fyll i");
            builder.setNegativeButton("Ok" , null);
            builder.create();
            builder.show();

        }
        else {

            editText.setText("");
            imageView.setImageResource(image.get(pos.nextInt(image.size())));
            Button button=(Button)findViewById(R.id.button1);
            button.setVisibility(View.GONE);
        }

    }

    public void quessbutton(View v){

        ImageView imageView=(ImageView) findViewById(R.id.imageView4);
        EditText editText=(EditText)findViewById(R.id.editText);
        TextView textView=(TextView)findViewById(R.id.textView);

        String text=editText.getText().toString();

        if(imageView.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.apelsin).getConstantState() && text.equals("apelsin") ){

           repeatmethod(v);
        }
        else if(imageView.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.brandbil).getConstantState() && text.equals("brandbil") ){

            repeatmethod(v);
        }
        else if(imageView.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.tandare).getConstantState() && text.equals("tändare") || text.equals("tandare") ){

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
