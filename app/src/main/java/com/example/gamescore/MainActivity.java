package com.example.gamescore;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private int score1 = 0, score2 = 0;
    private TextView Team1_Score;
    private TextView Team2_Score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("FirstBug", "onCreate");
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Team1_Score = findViewById(R.id.Team1_Score);
        Team2_Score = findViewById(R.id.Team2_Score);

        if (savedInstanceState != null) {
            score1 = savedInstanceState.getInt("score1");
            score2 = savedInstanceState.getInt("score2");
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        updateScore1();
        updateScore2();

        Team1_Score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("FirstBug", "Clicked Team1_Score" );
                score1++;
                updateScore1();
                String text = Team1_Score.getText().toString();
                if (text.equals("30")) {
                    Team1_Score.setText(R.string.you_win);
                    Team2_Score.setText(R.string.loser);
                    score2 = 0;
                    score1 = 0;
                }

            }
        });
        Team2_Score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                Log.d("FirstBug", "Clicked Team2_Score" );
                score2++;
                updateScore2();
                String text = Team2_Score.getText().toString();
                if (text.equals("30")) {
                    Team2_Score.setText(R.string.you_win);
                    Team1_Score.setText(R.string.loser);
                    score2 = 0;
                    score1 = 0;
                }
            }
        });
    }

    @Override
    protected void onStart() {
        Log.d("FirstBug","Start");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("FirstBug","Resume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("FirstBug","Pause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("FirstBug","Stop");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.d("FirstBug", "Restart");
        super.onRestart();
    }

    private void updateScore1() {
        Team1_Score.setText(String.valueOf(score1));
    }

    private void updateScore2 () {
        Team2_Score.setText(String.valueOf(score2));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("score1", score1);
        outState.putInt("score2", score2);
    }

    @Override
    protected void onDestroy() {
        Log.d("FirstBug", "onDestroy");
        super.onDestroy();
    }
}