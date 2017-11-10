package com.example.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SurveyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("SurveyActivity tag", "now running onCreate");
        setContentView(R.layout.activity_survey);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("SurveyActivity tag", "now running onStart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("SurveyActivity tag", "now running onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("SurveyActivity tag", "now running onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("SurveyActivity tag", "now running onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("SurveyActivity tag", "now running onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("SurveyActivity tag", "now running onRestart");
    }



    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.answer1_1:
                if (checked)
                    Toast.makeText(SurveyActivity.this, "You have chosen Strongly Disagree for question 1", Toast.LENGTH_SHORT).show();
                    break;
            case R.id.answer1_2:
                if (checked)
                    Toast.makeText(SurveyActivity.this, "You have chosen Disgree for question 1", Toast.LENGTH_SHORT).show();
                    break;
            case R.id.answer1_3:
                if (checked)
                    Toast.makeText(SurveyActivity.this, "You have chosen Agree for question 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.answer1_4:
                if (checked)
                    Toast.makeText(SurveyActivity.this, "You have chosen Strongly Agree for question 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.answer2_4:
                if (checked)
                    Toast.makeText(SurveyActivity.this, "You have chosen Strongly Agree for question 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.answer2_3:
                if (checked)
                    Toast.makeText(SurveyActivity.this, "You have chosen Agree for question 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.answer2_2:
                if (checked)
                    Toast.makeText(SurveyActivity.this, "You have chosen Disagree for question 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.answer2_1:
                if (checked)
                    Toast.makeText(SurveyActivity.this, "You have chosen Strongly Disagree for question 2", Toast.LENGTH_SHORT).show();
                break;
        };
    }

}
