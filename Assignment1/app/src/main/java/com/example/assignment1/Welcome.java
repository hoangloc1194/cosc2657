package com.example.assignment1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("Welcome " + message + " to my app \n Click the picture below to see my list of features");
        Log.i("Welcome tag", "now running onCreate");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Welcome tag", "now running onStart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Welcome tag", "now running onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Welcome tag", "now running onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Welcome tag", "now running onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Welcome tag", "now running onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Welcome tag", "now running onRestart");
    }
    public void listFeatureScreen (View view){
        Intent intent = new Intent(this, mainList.class);
        startActivityForResult(intent,1);
        finish();
    }
}
