package com.example.dicerollapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {


    public static final Random RANDOM = new Random();
    private Button rollDices;
    private ImageView imageView1, imageView2;
    private int value1 = 1;
    private int value2 = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rollDices = (Button) findViewById(R.id.rollDices);
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);


        rollDices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value1 = randomDiceValue();
                value2 = randomDiceValue();

                int res1 = getResources().getIdentifier("ic_dice_" + value1, "drawable", "com.example.dicerollapp2");
                int res2 = getResources().getIdentifier("ic_dice_" + value2, "drawable", "com.example.dicerollapp2");

                imageView1.setImageResource(res1);
                imageView2.setImageResource(res2);

            }
        });


        if (savedInstanceState != null) {
            value1 = savedInstanceState.getInt("count");
            value2 = savedInstanceState.getInt("count2");
            int res1 = getResources().getIdentifier("ic_dice_" + value1, "drawable", "com.example.dicerollapp2");
            int res2 = getResources().getIdentifier("ic_dice_" + value2, "drawable", "com.example.dicerollapp2");
            imageView1.setImageResource(res1);
            imageView2.setImageResource(res2);
        }
    }


    public static int randomDiceValue() {
        return RANDOM.nextInt(6) + 1;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", value1);
        outState.putInt("count2", value2);
    }


}