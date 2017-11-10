package com.example.assignment1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.CheckBox;
public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("MainActivity tag", "now running onCreate");
        setContentView(R.layout.activity_main);

        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        final Button b = (Button)findViewById(R.id.login);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {

                if (buttonView.isChecked()) {
                    b.setEnabled(true);
                } else {
                    b.setEnabled(false);
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity tag", "now running onStart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivity tag", "now running onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainActivity tag", "now running onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MainActivity tag", "now running onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainActivity tag", "now running onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("MainActivity tag", "now running onRestart");
    }

    public void welcomeMessage (View view) {
        Intent intent = new Intent(this, Welcome.class);
        EditText editText = (EditText) findViewById(R.id.username);
        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        String text = spinner.getSelectedItem().toString();
        if (text.equals("Male")){
            String message = "Mr. " + editText.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
        }
        else if (text.equals("Female")){
            String message = "Mrs. " + editText.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
        }
        else if (text.equals("Unknown")){
            String message = editText.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
        }
        startActivity(intent);
    }


}
