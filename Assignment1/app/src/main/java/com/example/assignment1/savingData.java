package com.example.assignment1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class savingData extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            // check Fields For Empty Values
            checkFieldsForEmptyValues();
        }
    };
    void checkFieldsForEmptyValues(){
        Button b = (Button) findViewById(R.id.save);
        Button go = (Button) findViewById(R.id.go);
        String s1 = username.getText().toString();
        String s2 = password.getText().toString();

        if(s1.equals("")|| s2.equals("")){
            b.setEnabled(false);
        } else {
            b.setEnabled(true);
            go.setEnabled(true);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("savingData tag", "now running onCreate");
        setContentView(R.layout.activity_saving_data);

        username = (EditText) findViewById(R.id.usernameView);
        password = (EditText) findViewById(R.id.passwordView);


        // set listeners
        username.addTextChangedListener(mTextWatcher);
        password.addTextChangedListener(mTextWatcher);

        // run once to disable if empty
        checkFieldsForEmptyValues();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("savingData tag", "now running onStart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("savingData tag", "now running onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("savingData tag", "now running onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("savingData tag", "now running onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("savingData tag", "now running onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("savingData tag", "now running onRestart");
    }



    public void save (View view){
        SharedPreferences sharedPref = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("name", username.getText().toString());
        editor.putString("password", password.getText().toString());
        editor.commit();

    }
    public void next (View view){
        final Toast toast =  Toast.makeText(this, "Next", Toast.LENGTH_SHORT);
        toast.show();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        }, 1000);
        Intent intent = new Intent (this, loadingData.class);
        startActivity(intent);
    }
}
