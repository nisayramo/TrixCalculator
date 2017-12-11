package com.example.yasin.trixcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class TrixActivity extends AppCompatActivity {
    private int trix;
    private boolean isScored = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trix);

        SeekBar seek = findViewById(R.id.Tseek);

        final TextView t1t = findViewById(R.id.team1T);
        final TextView t2t = findViewById(R.id.team2T);

        final ImageView image = findViewById(R.id.TrixImage);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isScored){
                    Intent intent = new Intent();
                    intent.putExtra("team1Score",trix);
                    setResult(RESULT_OK,intent);
                    finish();
                }

            }
        });

        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                int progress = seekBar.getProgress();
                isScored = true;
                switch (progress){
                    case 0:
                        t1t.setText("350");
                        t2t.setText("150");
                        trix=350;
                        break;
                    case 1:
                        t1t.setText("300");
                        t2t.setText("200");
                        trix=300;
                        break;
                    case 2:
                        t1t.setText("250");
                        t2t.setText("250");
                        trix=250;
                        break;
                    case 3:
                        t1t.setText("200");
                        t2t.setText("300");
                        trix=200;
                        break;
                    case 4:
                        t1t.setText("150");
                        t2t.setText("350");
                        trix=150;
                        break;
                    case 5:
                        t1t.setText("0");
                        t2t.setText("0");
                        trix=0;
                        isScored = false;
                        break;
                    case 6:
                        t1t.setText("350");
                        t2t.setText("150");
                        trix=350;
                        break;
                    case 7:
                        t1t.setText("300");
                        t2t.setText("200");
                        trix=300;
                        break;
                    case 8:
                        t1t.setText("250");
                        t2t.setText("250");
                        trix=250;
                        break;
                    case 9:
                        t1t.setText("200");
                        t2t.setText("300");
                        trix=200;
                        break;
                    case 10:
                        t1t.setText("150");
                        t2t.setText("350");
                        trix=150;
                        break;

                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


            }
        });
    }
}
