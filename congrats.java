package com.example.smeet.numberguessinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class congrats extends AppCompatActivity {
    private Button button;

    @Override
    //button which starts new game and save
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congrats);
        button= (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain();
            }
        });


    }
    //Method starts the main activity ( the number game) screen
    public void openMain() {
        Intent intent = new Intent(this,MainActivity.class );
        startActivity(intent);
    }



}
