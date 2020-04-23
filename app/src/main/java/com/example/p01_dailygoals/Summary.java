package com.example.p01_dailygoals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Summary extends AppCompatActivity {
Button btnClose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        Intent i = getIntent();
        String[] info = i.getStringArrayExtra("info");
        TextView tv1 = findViewById(R.id.textView1);
        TextView tv2 = findViewById(R.id.textView2);
        TextView tv3 = findViewById(R.id.textView3);
        TextView tv4 = findViewById(R.id.textView4);

        tv1.setText("Read up on materials before class: " + info[1]);
        tv2.setText("Arrive on time so as not to miss important " +"\n" +
                " part of the lesson:  " + info[2]);
        tv3.setText("Attempt the problem myself: " + info[3]);
        tv4.setText("Reflection: " + info[0]);

        btnClose = findViewById(R.id.button2);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
