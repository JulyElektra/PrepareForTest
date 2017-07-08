package com.example.elekt.preparefortest.View;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.elekt.preparefortest.R;

/**
 * Created by elekt on 03.07.2017.
 */

public class MainScreen extends Activity {

    private String[] programmingLanguages = {"All", "Java", "PHP", "C++", "Python", "C#"};
    private String[] levels = {"All", "Junior" , "Middle" ,"Senior"};
    private String[] topics = {"All", "Input and Output", "MultiThreading", "Loops"};

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen_layout);
        setSpinners(R.id.spinnerChooseProgLang, programmingLanguages, "Choose Programming language");
        setSpinners(R.id.spinnerChooseLevel, levels, "Choose your level");
        setSpinners(R.id.spinnerChooseTopic, topics, "Choose topic");

    }

    public void onClickSearch(View view) {

    }

    private void setSpinners(int id, String[] dataSet, String title) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dataSet);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner = (Spinner) findViewById(id);
        spinner.setAdapter(adapter);
        spinner.setPrompt(title);
        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Toast.makeText(getBaseContext(), "Position = " + position, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }
}
