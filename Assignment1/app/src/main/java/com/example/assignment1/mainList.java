package com.example.assignment1;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class mainList extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("mainList tag", "now running onCreate");
        setContentView(R.layout.list_feature);
        List<Feature> image_details = getListData();
        final ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new CustomListAdapter(this, image_details));

        // When user clicks on item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = listView.getItemAtPosition(position);
                Feature feature = (Feature) o;
                if (position == 2){
                    Intent intent = new Intent(mainList.this,savingData.class);
                    startActivity(intent);
                }
                else if (position == 0){
                    Intent intent = new Intent(mainList.this,SurveyActivity.class);
                    startActivity(intent);
                }
                else if (position == 1){
                    Intent intent = new Intent(mainList.this,MoneyActivity.class);
                    startActivity(intent);
                }
                else if (position == 3){
                    Intent intent = new Intent(mainList.this,PickerActivity.class);
                    startActivity(intent);
                }
                final Toast toast = Toast.makeText(mainList.this, "Selected :" + " " + feature, Toast.LENGTH_SHORT);
                toast.show();

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        toast.cancel();
                    }
                }, 1000);

            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("mainList tag", "now running onStart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("mainList tag", "now running onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("mainList tag", "now running onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("mainList tag", "now running onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("mainList tag", "now running onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("mainList tag", "now running onRestart");
    }


    private  List<Feature> getListData() {
        List<Feature> list = new ArrayList<Feature>();
        Feature survey = new Feature("Survey", "survey", "A simple survey");
        Feature money = new Feature("Money Convertor", "money", "Convert USD <-> VND");
        Feature savingData = new Feature("Saving data", "savingdata", "Apply SharedPreference");
        Feature datepicker = new Feature("Date and time picker", "calendar", "Pick date and time using pickers");

        list.add(survey);
        list.add(money);
        list.add(savingData);
        list.add(datepicker);

        return list;
    }
}