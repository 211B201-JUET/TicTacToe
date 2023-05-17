package com.example.tictactoe_211b201;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.media.Image;
import android.os.Bundle;
import android.view.View;

import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean player = true, isWinner = false; // True is player 1 otherwise Player 2
    int [][]winningStates = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int []gameState = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
    public void load(View view){
        ImageView v = (ImageView) view;
        int tag = Integer.parseInt(v.getTag().toString());
        if(isWinner==false && gameState[tag]==-1) {
            if (player) {
                v.setImageResource(R.drawable.cross);
                gameState[tag] = 1;
               Toast.makeText(this, "Crossed at " + tag, Toast.LENGTH_SHORT).show();
                player = false;
            } else {
                v.setImageResource(R.drawable.oval);
                gameState[tag] = 0;
                Toast.makeText(this, "Zeroed at " + tag, Toast.LENGTH_SHORT).show();
                player = true;
            }
            for (int i = 0; i < winningStates.length; i++) {
                if (gameState[winningStates[i][0]] == gameState[winningStates[i][1]] && gameState[winningStates[i][1]] == gameState[winningStates[i][2]] && gameState[winningStates[i][0]] > -1) {
                    Toast.makeText(this, "Winner: Player " + (player == false ? 1 : 2), Toast.LENGTH_SHORT).show();
                    isWinner = true;
                }
            }
        }
    }

    public void reset(View view){
        GridLayout gridLayout = findViewById(R.id.gridLayout);
        int totalImages = gridLayout.getChildCount();
        for(int i=0;i<totalImages;i++){
            ImageView v = (ImageView) gridLayout.getChildAt(i);
            v.setImageDrawable(null);
        }
        isWinner = false;
        player = true;
        for(int i = 0;i<9;i++){
            gameState[i]=-1;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
