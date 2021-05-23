package com.example.androidmidtermexam;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Activity2 extends AppCompatActivity {

    //declare variable for random number
    public static final Random randNumber = new Random();

    private ImageView diceImage1, diceImage2, diceImage3;

    // declare variables to hold the random value and initialize it
     int score1 = 0, score2 = 0, score3 = 0;

     int score1Player1 = 0, score2Player2 = 0, score3Player3 = 0;


    Boolean activePlayer1 = true;
    Boolean activePlayer2 = false;

    private final Integer gamePoint = 40;
    int clickPlayer1 = 0, clickPlayer2 = 0;



    TextView txtWinner;

    String GameEndMessage = null;

    String GameEndMessageDefault = null;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Button mRollPlayer1 = (Button) findViewById(R.id.btnPlayer1);

        Button mRollPlayer2 = (Button) findViewById(R.id.btnPlayer2);

        Button btnReset = (Button)findViewById(R.id.btnReset);


        diceImage1 =(ImageView) findViewById(R.id.imageDice1);
        diceImage2 =(ImageView) findViewById(R.id.imageDice2);
        diceImage3 =(ImageView) findViewById(R.id.imageView3);


        TextView mResultText1 =(TextView) findViewById(R.id.txtGamePoint1);

        TextView mResultText2 =(TextView) findViewById(R.id.txtGamePoint2);

        //Accessing the textView that display the winner
        txtWinner =(TextView) findViewById(R.id.txtViewWinner);


        mRollPlayer1.setEnabled(false);
        mRollPlayer2.setEnabled(false);

        btnReset.setOnClickListener(v -> {

            //reset the score for the players
            score1 = score2 = score3 = 0;

            score1Player1 = score2Player2 = score3Player3 = 0;

            //enable the buttons
            mRollPlayer1.setEnabled(true);
            mRollPlayer2.setEnabled(true);

            //clear the textView value
            mResultText1.setText("0");

            mResultText2.setText("0");

            txtWinner.setText("");

            //Make active the player 1
            activePlayer1 = true;
            activePlayer2 = false;

            //Reset clicks value
            clickPlayer1 = clickPlayer2 = 0;

            // clear the dice images
            diceImage1.setImageResource(R.drawable.empty_dice);
            diceImage2.setImageResource(R.drawable.empty_dice);
            diceImage3.setImageResource(R.drawable.empty_dice);
        });

        mRollPlayer1.setOnClickListener(v -> {

            mRollPlayer2.setEnabled(false);

            clickPlayer1++;

            if (clickPlayer1 >= 3){

                mRollPlayer1.setEnabled(false);
                mRollPlayer2.setEnabled(true);
            }

            int valueDice1 = randomNumberValue();
            int valueDice2 = randomNumberValue();
            int valueDice3 = randomNumberValue();

            int res1 = getResources().getIdentifier("dice_" + valueDice1,
                    "drawable", "com.example.androidmidtermexam");
            int res2 = getResources().getIdentifier("dice_" + valueDice2,
                    "drawable", "com.example.androidmidtermexam");

            int res3 = getResources().getIdentifier("dice_" + valueDice3,
                    "drawable", "com.example.androidmidtermexam");

            diceImage1.setImageResource(res1);
            diceImage2.setImageResource(res2);
            diceImage3.setImageResource(res3);

            if (activePlayer1){

                score1 = score1 + valueDice1;
                score2 = score2 + valueDice2;
                score3 = score3 + valueDice3;

                //the variable that hold the total score
                int totalScore1 = 0;

                totalScore1 = totalScore1 + (score1 + score2 + score3);

                mResultText1.setText(String.format("%d", totalScore1));

                /*activePlayer1 = false;
                activePlayer2 = true;*/

                if(totalScore1 >= 30){

                    GameEndMessageDefault = "The winner is";

                    GameEndMessage = GameEndMessageDefault + " Player 1\n you get $100.00";;

                    txtWinner.setText(GameEndMessage);

                    mRollPlayer1.setEnabled(false);

                    mRollPlayer2.setEnabled(false);
                }
               //  activePlayer1 = false;
                activePlayer2 = true;
            }


        });

        mRollPlayer2.setOnClickListener(V -> {

            int valueDice1 = randomNumberValue();
            int valueDice2 = randomNumberValue();
            int valueDice3 = randomNumberValue();

            int res1 = getResources().getIdentifier("dice_" + valueDice1,
                    "drawable", "com.example.androidmidtermexam");
            int res2 = getResources().getIdentifier("dice_" + valueDice2,
                    "drawable", "com.example.androidmidtermexam");

            int res3 = getResources().getIdentifier("dice_" + valueDice3,
                    "drawable", "com.example.androidmidtermexam");

            diceImage1.setImageResource(res1);
            diceImage2.setImageResource(res2);
            diceImage3.setImageResource(res3);

            if (activePlayer2){

                score1Player1 = score1Player1 + valueDice1;
                score2Player2 = score2Player2 + valueDice2;
                score3Player3 = score3Player3 + valueDice3;

                //the variable that hold the total score
                int totalScore2 = 0;

                totalScore2 = totalScore2 + (score1Player1 + score2Player2 + score3Player3);

                mResultText2.setText(String.format("%d",totalScore2));


                //check each point
                if(totalScore2 >= 30 ){

                    GameEndMessageDefault = "The winner is";

                    GameEndMessage = GameEndMessageDefault + " Player 2\n you get $100.00";

                    txtWinner.setText(GameEndMessage);

                    mRollPlayer1.setEnabled(false);

                    mRollPlayer2.setEnabled(false);

                }

                activePlayer1 = true;
               // activePlayer2 = false;
            }

            clickPlayer2++;

            if (clickPlayer2 >= 3){

                mRollPlayer2.setEnabled(false);
            }
        });

    }

    public static int randomNumberValue(){
        return randNumber.nextInt(6) + 1;
    }
}

