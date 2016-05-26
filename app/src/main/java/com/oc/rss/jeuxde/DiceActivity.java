package com.oc.rss.jeuxde;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.security.SecureRandom;

/**
 * Created by combo on 14/05/16.
 */
public class DiceActivity extends Activity implements View.OnClickListener {
    private TextView textResult;
    private int max;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);

        max = getIntent().getIntExtra("max", 0);

        TextView textTitle = (TextView) findViewById(R.id.textTitle);
        textTitle.setText(max + " sided dice");

        textResult = ((TextView) findViewById(R.id.textResult));
        textResult.setText("");

        Button buttonRoll = (Button) findViewById(R.id.buttonRoll);

        Button buttonNext = (Button) findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DiceActivity.this, NextActivity.class);
                startActivity(intent);
            }
        });

        Button buttonRetiredPlayers = (Button) findViewById(R.id.buttonRPlayers);
        buttonRetiredPlayers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(DiceActivity.this, RetiredplayersActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        SecureRandom random = new SecureRandom();
        int result = random.nextInt(max) + 1;
        textResult.setText(String.valueOf(result));
    }
}
