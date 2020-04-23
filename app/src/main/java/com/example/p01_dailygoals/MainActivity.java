package com.example.p01_dailygoals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

EditText etReflection;
RadioButton rb1, rb2, rb3;
RadioGroup rg1, rg2, rg3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup rg1 = (RadioGroup) findViewById(R.id.radioGroup1);
                RadioGroup rg2 = (RadioGroup) findViewById(R.id.radioGroup2);
                RadioGroup rg3 = (RadioGroup) findViewById(R.id.radioGroup3);

                int selectedButtonId1 = rg1.getCheckedRadioButtonId();
                int selectedButtonId2 = rg2.getCheckedRadioButtonId();
                int selectedButtonId3 = rg3.getCheckedRadioButtonId();

                RadioButton rb1 = (RadioButton) findViewById(selectedButtonId1);
                RadioButton rb2 = (RadioButton) findViewById(selectedButtonId2);
                RadioButton rb3 = (RadioButton) findViewById(selectedButtonId3);

                EditText etReflection = (EditText) findViewById(R.id.editTextReflection);

                String[] info = {etReflection.getText().toString(), rb1.getText().toString(), rb2.getText().toString(), rb3.getText().toString()};

                Intent i = new Intent(MainActivity.this, Summary.class);

                i.putExtra("info", info);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        RadioGroup rg1 = (RadioGroup) findViewById(R.id.radioGroup1);
        RadioGroup rg2 = (RadioGroup) findViewById(R.id.radioGroup2);
        RadioGroup rg3 = (RadioGroup) findViewById(R.id.radioGroup3);

        int selectedButtonId1 = rg1.getCheckedRadioButtonId();
        int selectedButtonId2 = rg2.getCheckedRadioButtonId();
        int selectedButtonId3 = rg3.getCheckedRadioButtonId();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = prefs.edit();

//        String[] info = {etReflection.getText().toString()};
//        Integer[] rbInfo = {selectedButtonId1, selectedButtonId2, selectedButtonId3};
        prefEdit.putString("reflection", etReflection.getText().toString());
        prefEdit.putInt("rb1", selectedButtonId1);
        prefEdit.putInt("rb2", selectedButtonId2);
        prefEdit.putInt("rb3", selectedButtonId3);
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        EditText etReflection = (EditText) findViewById(R.id.editTextReflection);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String reflection = prefs.getString("reflection", "");
        int rb1S = prefs.getInt("rb1", 0);
        int rb2S = prefs.getInt("rb2", 0);
        int rb3S = prefs.getInt("rb3", 0);

        etReflection.setText(reflection);
        rg1.check(rb1S);
        rg2.check(rb2S);
        rg3.check(rb3S);
        



//        if(rb1S == 0){
//            rb1.setChecked(true);
//        }else{
//            rb1.setChecked(false);
//
//        }
//        if(rb2S == 0){
//            rb2.setChecked(true);
//        }else{
//            rb2.setChecked(false);
//
//        }
//
//        if(rb3S == 0){
//            rb3.setChecked(true);
//        }else{
//            rb3.setChecked(false);

//        }



    }

}
