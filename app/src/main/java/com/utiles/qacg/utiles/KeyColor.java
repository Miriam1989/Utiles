package com.utiles.qacg.utiles;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import java.lang.*;

public class KeyColor extends AppCompatActivity implements View.OnClickListener{

    private TextView number_key_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key_color);

        number_key_1=(TextView)findViewById(R.id.number_key_1);
        number_key_1.setOnClickListener(this);


    }
    private boolean stateChanged;

    @Override
    public void onClick(View v) {

        if(stateChanged) {
            // reset background to default;
            number_key_1.setBackgroundColor(Color.BLUE);
        } else {
            number_key_1.setBackgroundColor(Color.BLACK);
        }
        stateChanged = !stateChanged;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}



