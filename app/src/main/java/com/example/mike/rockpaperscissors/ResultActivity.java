package com.example.mike.rockpaperscissors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private TextView playerName;
    private TextView playerWinCount;
    private TextView playerHand;
    private TextView cpuName;
    private TextView cpuWinCount;
    private TextView cpuHand;
    private TextView gameResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        this.gameResult = findViewById(R.id.resultTextViewID);
        this.playerName = findViewById(R.id.playerNameTextViewID);
        this.cpuName = findViewById(R.id.cpuNameTextViewID);
        this.playerWinCount = findViewById(R.id.playerWinCountTextViewID);
        this.cpuWinCount = findViewById(R.id.cpuWinCountTextViewID);


        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String result = extras.getString("result");
        String name = extras.getString("name");
        String robot = extras.getString("robot");
        String playerScore = extras.getString("playerScore");
        String robotScore = extras.getString("robotScore");


        gameResult.setText(result);
        playerName.setText(name);
        cpuName.setText(robot);
        playerWinCount.setText(playerScore);
        cpuWinCount.setText(robotScore);


    }
}
