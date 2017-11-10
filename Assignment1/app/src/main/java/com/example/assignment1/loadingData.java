package com.example.assignment1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class loadingData extends AppCompatActivity {
    public static final String DEFAULT = "";
    TextView userNameTextView, passwordTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Loading Data tag", "now running onCreate");
        setContentView(R.layout.activity_loading_data);
        userNameTextView = (TextView) findViewById(R.id.textViewTest1);
        passwordTextView = (TextView) findViewById(R.id.textViewTest2);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Loading Data tag", "now running onStart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Loading Data tag", "now running onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Loading Data tag", "now running onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Loading Data tag", "now running onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Loading Data tag", "now running onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Loading Data tag", "now running onRestart");
    }

    public void load (View view){
        SharedPreferences sharedPref = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String name = sharedPref.getString("name",DEFAULT);
        String password = sharedPref.getString("password",DEFAULT);
        if (name.equals(DEFAULT) || password.equals(DEFAULT)){
            final Toast toast = Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT);
            toast.show();

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    toast.cancel();
                }
            }, 2000);
        } else{
            final Toast toast = Toast.makeText(this, "Load Data Successfully", Toast.LENGTH_SHORT);
            toast.show();

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    toast.cancel();
                }
            }, 2000);
            userNameTextView.setText(name);
            passwordTextView.setText(password);
        }
    }
    public void previous (View view){
        Intent intent = new Intent (this, savingData.class);
        startActivity(intent);
    }
}
