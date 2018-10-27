package com.example.smeet.numberguessinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private int randomNumber = (int) (Math.random() * 100 + 1); // Generates random number to guess
    private ArrayList<Integer> yourNumbersHigh = new ArrayList<Integer>();// Stores the current games guess high input
    private ArrayList<Integer> yourNumbersLow = new ArrayList<Integer>();// Stores the current games guess Low input
    //    private ArrayList<HighScore> highScore = new ArrayList<HighScore>();// Stores the current games guess Low input
    public int totalScore;// Starting score starts at 100 and reduces per guess
    public int hintNum;
    //initialing the fields and text
    TextView myscore;
    TextView myfeed;
    TextView hint;
    TextView high;
    TextView low;
    EditText e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //allows multiple buttons
        ButtonHandler bh = new ButtonHandler();
        findViewById(R.id.guessNum).setOnClickListener(bh);
        findViewById(R.id.hintbnt).setOnClickListener(bh);
        findViewById(R.id.newgame).setOnClickListener(bh);
        findViewById(R.id.sb).setOnClickListener(bh);

        //on create values and elements
        totalScore = 100;hintNum = 0;
        e = (EditText) findViewById(R.id.input);
        myfeed = (TextView) findViewById(R.id.Feedback);
        hint = (TextView) findViewById(R.id.hint);
        high = (TextView) findViewById(R.id.High);
        low = (TextView) findViewById(R.id.Low);
        myscore = (TextView) findViewById(R.id.score);
        myscore.setText("Score: "+totalScore);
        hint.setText("Hints used " + hintNum);

    }
    private class ButtonHandler implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                //number is guessed
                case R.id.guessNum:
                    totalScore=totalScore-10;
                    myscore.setText("Score: " + totalScore);
                    int number = Integer.parseInt(e.getText().toString());
                    myfeed.setText("");
                    if(number==randomNumber) {
                        myfeed.setText("Correct Guess");
                        openMain();
                    }
                    else if(number<randomNumber){
                        myfeed.setText("Guess Too low");
                        yourNumbersLow.add(number);
                        low.setText("Your Low Guesses " + yourNumbersLow.toString());
                    }
                    else if(number>randomNumber){
                        myfeed.setText("Guess Too high");
                        yourNumbersHigh.add(number);
                        high.setText("Your High Guesses " + yourNumbersHigh.toString());
                    }
                        if(number>100 || number<0){
                    myfeed.setText("Enter Number from 1 to 100 above");
                    }
                    e.setText("");
                    break;
                    //hint is pressed
                case R.id.hintbnt:
                    int randLow = (int) (randomNumber - Math.random() * 6);
                    int randHi = (int) (Math.random() * 6 + randomNumber);
                    hintNum = hintNum + 1;
                    hint.setText("Hints used " + hintNum);
                    totalScore = totalScore - 20;
                    myscore.setText("Score: " + totalScore);
                    myfeed.setText("Hint: bewteen " + randLow + " and " + randHi);
                    break;
                case R.id.newgame:
                    //call on method for new game
                    ng();
                    break;
                case R.id.sb:
                    //changes activity for now
                    openMain();
                    break;
                default:
//                    show("This should not happen");
            }
        }
    }

    //new game
    public void ng() {
        hintNum=0;
        hint.setText("Hints used "+hintNum);
        e.setText("");
        totalScore=100;
        myscore.setText("Score: " + totalScore);
        yourNumbersHigh.clear();
        high.setText("Your High Guesses " + yourNumbersHigh.toString());
        yourNumbersLow.clear();
        low.setText("Your Low Guesses " + yourNumbersLow.toString());
        myfeed.setText("Enter Number from 1 to 100 above");
    }

    //saving the state of the game
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("totalScore", totalScore);
        outState.putInt("hintNum", hintNum);
        outState.putInt("randomNumber", randomNumber);
        outState.putIntegerArrayList("yourNumbersHigh", yourNumbersHigh );
        outState.putIntegerArrayList("yourNumbersLow", yourNumbersLow );
    }

    //reloading the state of the game
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        totalScore = savedInstanceState.getInt("totalScore");
        hintNum = savedInstanceState.getInt("hintNum");
        randomNumber = savedInstanceState.getInt("randomNumber");
        yourNumbersHigh = savedInstanceState.getIntegerArrayList("yourNumbersHigh");
        yourNumbersLow = savedInstanceState.getIntegerArrayList("yourNumbersLow");
    }
    public void openMain() {
        Intent intent = new Intent(this,congrats.class );
        startActivity(intent);
    }

}