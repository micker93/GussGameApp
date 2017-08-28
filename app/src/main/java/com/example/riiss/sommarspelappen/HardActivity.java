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

import java.util.ArrayList;
import java.util.Random;

public class HardActivity extends AppCompatActivity {

    int score=0;
    ArrayList<Integer> image=new ArrayList<Integer>();
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
        editText.setText("");

        Button button=(Button)findViewById(R.id.button1);
        button.setVisibility(View.GONE);

        if(imageView.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.frekvens).getConstantState()) {

            imageView.setImageResource(R.drawable.kongress);

        }
        else if(imageView.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.kongress).getConstantState()) {

            imageView.setImageResource(R.drawable.kirurg);

        }
        else if(imageView.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.kirurg).getConstantState()) {

            imageView.setImageResource(R.drawable.frekvens);

        }


    }

    public void quessbutton(View v){

        ImageView imageView=(ImageView) findViewById(R.id.imageView4);
        EditText editText=(EditText)findViewById(R.id.editText);
        TextView textView=(TextView)findViewById(R.id.textView);

        String text=editText.getText().toString();

        if(imageView.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.kongress).getConstantState()
           && text.equals("kongress") ){

            repeatmethod(v);

        }
        else if(imageView.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.frekvens).getConstantState()
             && text.equals("frekvens") ){

            repeatmethod(v);

        }
        else if(imageView.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.kirurg).getConstantState()
             && text.equals("kirurg") || text.equals("tandare") ){

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
