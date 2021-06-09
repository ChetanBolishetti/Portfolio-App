package com.example.chetancv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.WindowManager;

public class pop_up_window extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_window);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width*0.7),(int)(height*0.5));

        WindowManager.LayoutParams parms = getWindow().getAttributes();
        parms.gravity = Gravity.CENTER;
        parms.x = 0;
        parms.y = -20;
        getWindow().setAttributes(parms);

    }
}
