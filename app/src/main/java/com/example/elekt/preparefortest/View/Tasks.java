package com.example.elekt.preparefortest.View;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.FragmentTransaction;

import com.example.elekt.preparefortest.R;
import com.example.elekt.preparefortest.View.Fragments.TasksListFragmentRecycler;

/**
 * Created by elekt on 13.07.2017.
 */

public class Tasks extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasks_layout);
        Fragment fragment = new TasksListFragmentRecycler();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        int container = R.id.tasksFragmentContainer;
        fragmentTransaction.add(container, fragment, "fragm_tasks");
        fragmentTransaction.commit();
    }
}
