package com.example.elekt.preparefortest.View;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.elekt.preparefortest.Model.INameable;
import com.example.elekt.preparefortest.Model.Model;
import com.example.elekt.preparefortest.Model.Test;
import com.example.elekt.preparefortest.Presenter.TestsManager;
import com.example.elekt.preparefortest.R;
import com.example.elekt.preparefortest.View.Fragments.TestsListFragmentRecycler;

import java.util.Collection;

/**
 * Created by elekt on 03.07.2017.
 */

public class MainScreen extends Activity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen_layout);
        Model model = new Model(MainScreen.this);
        String[] programmingLanguages = getNames(model.getAllProgrammingLanguages());
        setSpinners(R.id.spinnerChooseProgLang, programmingLanguages, "Choose Programming language");
        String[] levels = getNames(model.getAllLevels());
        setSpinners(R.id.spinnerChooseLevel, levels, "Choose your level");
        String[] topics = getNames(model.getAllTopics());
        setSpinners(R.id.spinnerChooseTopic, topics, "Choose topic");

        Spinner s3 = (Spinner)findViewById(R.id.spinnerChooseTopic);
        Spinner s2 = (Spinner)findViewById(R.id.spinnerChooseLevel);
        Spinner s1 = (Spinner)findViewById(R.id.spinnerChooseProgLang);
        Collection<Test> tests = new Model(MainScreen.this).getTests(s1.getSelectedItem().toString(),
                s2.getSelectedItem().toString(), s3.getSelectedItem().toString());
//        ((TestsListFragmentRecycler) fragment).setTests(tests);
        TestsManager.setTestsCurrent(tests);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = new TestsListFragmentRecycler();


        fragmentTransaction.add(R.id.fragmentContainer, fragment, "frag_teg");
        fragmentTransaction.commit();

    }

    private String[] getNames(Collection<? extends INameable> items) {
        String[] itemNames = new String[items.size()];
        int n = 0;
        for (INameable item: items) {
            itemNames[n] = item.getName();
            n++;
        }
        return itemNames;
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
