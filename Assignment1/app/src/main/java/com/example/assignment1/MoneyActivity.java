package com.example.assignment1;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import static java.lang.Double.parseDouble;

public class MoneyActivity extends AppCompatActivity {
    private Double vnd = new Double(0);
    private Double usd = new Double(0);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("MoneyActivity tag", "now running onCreate");
        setContentView(R.layout.activity_money_activity);
        ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleButton);
        final Button usdToVND = (Button) findViewById(R.id.usdToVND);
        final Button vndToUSD = (Button) findViewById(R.id.vndToUsd);
        final EditText resultUSD = (EditText) findViewById(R.id.resultUsd);
        final EditText resultVND = (EditText) findViewById(R.id.resultVND);

        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    usdToVND.setEnabled(false);
                    vndToUSD.setEnabled(true);
                    resultUSD.setEnabled(false);
                    resultVND.setEnabled(true);
                } else {
                    vndToUSD.setEnabled(false);
                    usdToVND.setEnabled(true);
                    resultUSD.setEnabled(true);
                    resultVND.setEnabled(false);
                }
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MoneyActivity tag", "now running onStart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MoneyActivity tag", "now running onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MoneyActivity tag", "now running onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MoneyActivity tag", "now running onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MoneyActivity tag", "now running onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("MoneyActivity tag", "now running onRestart");
    }

    public void vndToUSD (View view){
        EditText editTextVND = (EditText) findViewById(R.id.resultVND);
        vnd = parseDouble(editTextVND.getText().toString());
        usd = vnd/22727.2727;
        TextView textView = (TextView) findViewById(R.id.resultUsd);
        textView.setText(usd.toString() );
        final Toast toast =  Toast.makeText(this, "You have changed " + vnd.toString() + " VND to " + usd.toString() +" USD",
                Toast.LENGTH_SHORT);
        toast.show();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        }, 1000);
    }
    public void usdToVND (View view){
        EditText editTextVND = (EditText) findViewById(R.id.resultUsd);
        usd = parseDouble(editTextVND.getText().toString());
        vnd = usd*22727.2727;
        TextView textView = (TextView) findViewById(R.id.resultVND);
        textView.setText(vnd.toString() );
        final Toast toast =  Toast.makeText(this, "You have changed " + usd.toString() + " USD to " + vnd.toString() +" VND",
                Toast.LENGTH_SHORT);
        toast.show();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        }, 1000);
    }
}
