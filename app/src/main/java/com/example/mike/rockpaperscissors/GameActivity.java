package com.example.mike.rockpaperscissors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mike.rockpaperscissors.GameModels.Contestants.CPU;
import com.example.mike.rockpaperscissors.GameModels.Contestants.Player;
import com.example.mike.rockpaperscissors.GameModels.Game;
import com.example.mike.rockpaperscissors.GameModels.Hand.Hand;
import com.example.mike.rockpaperscissors.GameModels.Hand.Paper;
import com.example.mike.rockpaperscissors.GameModels.Hand.Rock;
import com.example.mike.rockpaperscissors.GameModels.Hand.Scissors;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {
    private Game game;
    private TextView playerName;
    private TextView playerWinCount;
    private TextView playerHand;
    private TextView cpuName;
    private TextView cpuWinCount;
    private TextView cpuHand;
    private TextView gameResult;
    private ImageButton scissorsButton;
    private ImageButton paperButton;
    private ImageButton rockButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        this.playerName = findViewById(R.id.playerNameTextViewID);
        this.playerWinCount = findViewById(R.id.playerWinCountTextViewID);
        this.playerHand = findViewById(R.id.playerHandTextViewID);
        this.cpuName = findViewById(R.id.cpuNameTextViewID);
        this.cpuWinCount = findViewById(R.id.cpuWinCountTextViewID);
        this.cpuHand = findViewById(R.id.cpuHandTextViewID);
        this.gameResult = findViewById(R.id.resultTextViewID);
        this.scissorsButton = findViewById(R.id.scissorsButtonID);
        this.paperButton = findViewById(R.id.paperButtonID);
        this.rockButton = findViewById(R.id.rockButtonID);
        ArrayList<Hand> cpuChoices = new ArrayList<>();
        cpuChoices.add(new Rock());
        cpuChoices.add(new Scissors());
        cpuChoices.add(new Paper());
        if (game == null){
        this.game = new Game(new Player(), new CPU(), cpuChoices);}
        refresh();
    }

    public void refreshHuman(){
        playerName.setText(game.getHuman().getName());
        playerWinCount.setText(game.getHuman().getWinCount());
        if (game.getHuman().getHand() != null) playerHand.setText(game.getHuman().getHand().getName());
    }

    public void refreshCPU(){
        cpuName.setText(game.getCpu().getName());
        cpuWinCount.setText(game.getCpu().getWinCount());
        if (game.getCpu().getHand() != null) cpuHand.setText(game.getCpu().getHand().getName());
    }

    public void refresh(){
        refreshHuman();
        refreshCPU();
    }

    public void cpuChoice(){
        game.cpuChoice();
    }

    public void passToResult(){
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("result", gameResult.getText());
        intent.putExtra("name", game.getHuman().getName());
        intent.putExtra("robot", game.getCpu().getName());
        intent.putExtra("playerScore", game.getHuman().getWinCount());
        intent.putExtra("robotScore", game.getCpu().getWinCount());
        startActivity(intent);
    }


    public void onClickScissorsButton(View button){
        game.getHuman().setHand(new Scissors());
        game.cpuChoice();
        gameResult.setText(game.getResult());
        refresh();
        passToResult();
    }

    public void onClickRockButton(View button){
        game.getHuman().setHand(new Rock());
        game.cpuChoice();
        gameResult.setText(game.getResult());
        refresh();
        passToResult();
    }

    public void onClickPaperButton(View button){
        game.getHuman().setHand(new Paper());
        game.cpuChoice();
        gameResult.setText(game.getResult());
        refresh();
        passToResult();
    }


}
