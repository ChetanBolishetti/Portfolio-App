package com.example.chetancv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class pop_up_window extends AppCompatActivity {

    DatabaseReference myref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_window);

        TextView java,ds,ad,wb;
        ProgressBar jpb,dspb,adpb,wbpb;
        jpb = findViewById(R.id.javapb);
        dspb = findViewById(R.id.dspb);
        adpb = findViewById(R.id.androidpb);
        wbpb = findViewById(R.id.webpb);
        ProgressBar cpb = findViewById(R.id.cpb);
        cpb.setVisibility(View.VISIBLE);


        java = findViewById(R.id.java);
        ds = findViewById(R.id.ds);
        ad = findViewById(R.id.android);
        wb = findViewById(R.id.web);

        myref = FirebaseDatabase.getInstance().getReference().child("Data");
        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String kjava = snapshot.child("Java").getKey().toString();
                String kds = snapshot.child("Data Structure and Algo").getKey().toString();
                String kad = snapshot.child("Android Development").getKey().toString();
                String kwb = snapshot.child("Web Development").getKey().toString();

                String pj = snapshot.child("Java").getValue().toString();
                int fpj = Integer.parseInt(pj);

                String pd = snapshot.child("Data Structure and Algo").getValue().toString();
                int fpd = Integer.parseInt(pd);

                String pad = snapshot.child("Android Development").getValue().toString();
                int fpad = Integer.parseInt(pad);

                String pwbd = snapshot.child("Web Development").getValue().toString();
                int fpwbd = Integer.parseInt(pwbd);

                java.setText(kjava);
                ds.setText(kds);
                ad.setText(kad);
                wb.setText(kwb);

                jpb.setProgress(fpj);
                dspb.setProgress(fpd);
                adpb.setProgress(fpad);
                wbpb.setProgress(fpwbd);

                jpb.setVisibility(View.VISIBLE);
                dspb.setVisibility(View.VISIBLE);
                adpb.setVisibility(View.VISIBLE);
                wbpb.setVisibility(View.VISIBLE);

                cpb.setVisibility(View.INVISIBLE);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

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
