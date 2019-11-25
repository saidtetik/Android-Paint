package com.example.paintnote;


import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button clear;
    PaintView paintView;
    SeekBar seekBar;
    View divider;
    ImageButton black;
    ImageButton red;
    ImageButton orange;
    ImageButton blue;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clear = findViewById(R.id.clear);
        seekBar = findViewById(R.id.seekbar);
        divider = findViewById(R.id.divider);
        paintView = findViewById(R.id.paintview);
        red = findViewById(R.id.red);
        blue = findViewById(R.id.blue);
        orange = findViewById(R.id.orange);
        black = findViewById(R.id.black);
        clear.setOnClickListener(this);
        red.setOnClickListener(this);
        black.setOnClickListener(this);
        blue.setOnClickListener(this);
        orange.setOnClickListener(this);
        // Clear button's text color changed!
        clear.setTextColor(Color.WHITE);
        // Seek bar's max value changed!
        seekBar.setMax(20);
        seekBar.setProgress(5);

        divider.setBackgroundColor(getResources().getColor(R.color.blue));



        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                paintView.stroke = seekBar.getProgress();



            }
        });




    }

    @Override
    public void onClick(View v) {
        if(v.getId()==red.getId())
            paintView.color = Color.RED;

        else if (v.getId()==blue.getId())
            paintView.color = Color.BLUE;
        else if (v.getId()==orange.getId())
            paintView.color = Color.rgb(255, 87, 34);
        else if  (v.getId()==black.getId())
            paintView.color=Color.BLACK;
        else
            paintView.clear();

    }
}
