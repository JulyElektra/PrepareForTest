package com.example.elekt.preparefortest.View;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.elekt.preparefortest.Model.ProgrammingLanguage;
import com.example.elekt.preparefortest.Model.Task;
import com.example.elekt.preparefortest.Presenter.TasksManager;
import com.example.elekt.preparefortest.R;
import com.example.elekt.preparefortest.View.Adaptors.tasks.RecyclerAdaptorListTasks;
import com.example.elekt.preparefortest.View.Adaptors.tasks.RecyclerHolderListTasks;
import com.example.elekt.preparefortest.View.Fragments.TasksListFragmentRecycler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * Created by elekt on 13.07.2017.
 */

public class Tasks extends Activity {
    Fragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasks_layout);
        fragment = new TasksListFragmentRecycler();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        int container = R.id.tasksFragmentContainer;
        fragmentTransaction.add(container, fragment, "fragm_tasks");
    }


    public void onClickFinish(View view) {
        if (fragment != null ) {
            View parent = (View) view.getParent();
            RecyclerView recycler = (RecyclerView) parent.findViewById(R.id.taskRecyclerView);
            RecyclerView.Adapter adapter = recycler.getAdapter();
            int numElements = adapter.getItemCount();


            for (int position = 0; position < numElements; position++) {
                //TODO
                RecyclerView.ViewHolder currentViewHolder = recycler.findViewHolderForAdapterPosition(position);

                if (currentViewHolder == null) continue;
                RecyclerHolderListTasks cvh = (RecyclerHolderListTasks) currentViewHolder;

                int idTask = Integer.parseInt(cvh.getIdTask().getText().toString());
                Task task = TasksManager.getTaskByIdFromCurrent(idTask);
                Map<String, Boolean> answers = task.getPossibleAnswers();

                ListView listAnswers = (ListView) cvh.getAnswers();
                int numOfAnswers = listAnswers.getAdapter().getCount();
                for (int answerNumber = 0; answerNumber < numOfAnswers; answerNumber++) {
                    String t = (String) listAnswers.getAdapter().getItem(answerNumber);
                    Object o = listAnswers.getItemAtPosition(answerNumber);
                    ArrayList<View> outputViews = new ArrayList<View>();
                    listAnswers.findViewsWithText(outputViews, o.toString(), View.FIND_VIEWS_WITH_TEXT);
                    boolean checked = ((CheckBox)outputViews.get(0)).isChecked();
                    boolean correctAnswers = answers.get(o.toString());
                    if (correctAnswers == true && checked == true) {
                        ((View)((CheckBox)outputViews.get(0)).getParent()).setBackgroundColor(Color.GREEN);
                    } else if (correctAnswers == false && checked == true) {
                        ((View)((CheckBox)outputViews.get(0)).getParent()).setBackgroundColor(Color.RED);
                    } else if (correctAnswers == true && checked == false) {
                        ((View)((CheckBox)outputViews.get(0)).getParent()).setBackgroundColor(Color.RED);
                    }
                }

            }


            System.out.println("!!!!!!!!!!!!!" + numElements);
        }
    }
}
