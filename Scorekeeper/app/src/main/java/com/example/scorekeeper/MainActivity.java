package com.example.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mScore1;
    private int mScore2;

    private TextView mScoreText1;
    private TextView mScoreText2;

    static final String STATE_SCORE_1 = "Team 1 Score";
    static final String STATE_SCORE_2 = "Team 2 Score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScoreText1 = (TextView)findViewById(R.id.score_1);
        mScoreText2 = (TextView)findViewById(R.id.score_2);

        if (savedInstanceState != null) {
            mScore1 = savedInstanceState.getInt(STATE_SCORE_1);
            mScore2 = savedInstanceState.getInt(STATE_SCORE_2);

            //Set the score text views
            mScoreText1.setText(String.valueOf(mScore1));
            mScoreText2.setText(String.valueOf(mScore2));
        }
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // Save the scores.
        outState.putInt(STATE_SCORE_1, mScore1);
        outState.putInt(STATE_SCORE_2, mScore2);
        super.onSaveInstanceState(outState);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Check if the correct item was clicked
        if(item.getItemId()==R.id.night_mode){}

        return true;
    }

    public void decreaseScore(View view) {
        // Get the ID of the button that was clicked
        int viewID = view.getId();
        switch (viewID){
            //If it was on Team 1
            case R.id.decreaseTeam1:
                //Decrement the score and update the TextView
                mScore1--;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            //If it was Team 2
            case R.id.decreaseTeam2:
                //Decrement the score and update the TextView
                mScore2--;
                mScoreText2.setText(String.valueOf(mScore2));
        }
    }

    /**
     * Method that handles the onClick of both the increment buttons
     * @param view The button view that was clicked
     */
    public void increaseScore(View view) {
        //Get the ID of the button that was clicked
        int viewID = view.getId();
        switch (viewID){
            //If it was on Team 1
            case R.id.increaseTeam1:
                //Increment the score and update the TextView
                mScore1++;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            //If it was Team 2
            case R.id.increaseTeam2:
                //Increment the score and update the TextView
                mScore2++;
                mScoreText2.setText(String.valueOf(mScore2));
        }
    }




}