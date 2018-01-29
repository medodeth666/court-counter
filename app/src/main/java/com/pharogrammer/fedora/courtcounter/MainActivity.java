package com.pharogrammer.fedora.courtcounter;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int teamAscore = 0;
    int teamBscore = 0;
    TextView teamScore_A, teamScore_B;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            teamAscore = savedInstanceState.getInt("TeamA");
            teamBscore = savedInstanceState.getInt("TeamB");
        }
        setContentView(R.layout.activity_main);

        //Initialization of the views
        Button ptsA_3 = findViewById(R.id.btn_3pts_A);
        Button ptsA_2 = findViewById(R.id.btn_2pts_A);
        Button ptsA_free = findViewById(R.id.btn_free_throw_A);
        Button ptsB_3 = findViewById(R.id.btn_3pts_B);
        Button ptsB_2 = findViewById(R.id.btn_2pts_B);
        Button ptsB_free = findViewById(R.id.btn_free_throw_B);
        Button reset = findViewById(R.id.btn_reset);

        ptsA_3.setOnClickListener(this);
        ptsA_2.setOnClickListener(this);
        ptsA_free.setOnClickListener(this);
        ptsB_3.setOnClickListener(this);
        ptsB_2.setOnClickListener(this);
        ptsB_free.setOnClickListener(this);
        reset.setOnClickListener(this);

        teamScore_A = findViewById(R.id.tv_team_A_score);
        teamScore_B = findViewById(R.id.tv_team_B_score);

        teamScore_A.setText(String.valueOf(teamAscore));
        teamScore_B.setText(String.valueOf(teamBscore));
        checkWinner(teamScore_A, teamScore_B);


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("TeamA", teamAscore);
        outState.putInt("TeamB", teamBscore);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_3pts_A:
                teamAscore += 3;
                teamScore_A.setText(String.valueOf(teamAscore));
                checkWinner(teamScore_A, teamScore_B);
                break;
            case R.id.btn_2pts_A:
                teamAscore += 2;
                teamScore_A.setText(String.valueOf(teamAscore));
                checkWinner(teamScore_A, teamScore_B);
                break;
            case R.id.btn_free_throw_A:
                teamAscore += 1;
                teamScore_A.setText(String.valueOf(teamAscore));
                checkWinner(teamScore_A, teamScore_B);
                break;

            case R.id.btn_3pts_B:
                teamBscore += 3;
                teamScore_B.setText(String.valueOf(teamBscore));
                checkWinner(teamScore_A, teamScore_B);
                break;
            case R.id.btn_2pts_B:
                teamBscore += 2;
                teamScore_B.setText(String.valueOf(teamBscore));
                checkWinner(teamScore_A, teamScore_B);
                break;
            case R.id.btn_free_throw_B:
                teamBscore += 1;
                teamScore_B.setText(String.valueOf(teamBscore));
                checkWinner(teamScore_A, teamScore_B);
                break;

            case R.id.btn_reset:
                teamAscore = 0;
                teamBscore = 0;
                teamScore_A.setText(String.valueOf(teamAscore));
                teamScore_B.setText(String.valueOf(teamBscore));
                checkWinner(teamScore_A, teamScore_B);
                break;

        }
    }

    private void checkWinner(TextView tv1, TextView tv2) {
        int tv1_value = Integer.valueOf(tv1.getText().toString().trim());
        int tv2_value = Integer.valueOf(tv2.getText().toString().trim());
        if (tv1_value > tv2_value) {
            tv1.setTextColor(Color.parseColor("#2E7D32"));
            tv2.setTextColor(Color.BLACK);
        } else if (tv1_value < tv2_value) {
            tv2.setTextColor(Color.parseColor("#2E7D32"));
            tv1.setTextColor(Color.BLACK);
        } else {
            tv2.setTextColor(Color.BLACK);
            tv1.setTextColor(Color.BLACK);
        }
    }
}
