package com.example.elekt.preparefortest.View;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.example.elekt.preparefortest.Model.ProgrammingLanguage;
import com.example.elekt.preparefortest.R;
import com.example.elekt.preparefortest.View.Adaptors.tasks.RecyclerAdaptorListTasks;
import com.example.elekt.preparefortest.View.Adaptors.tasks.RecyclerHolderListTasks;
import com.example.elekt.preparefortest.View.Fragments.TasksListFragmentRecycler;

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
                RecyclerView.ViewHolder currentViewHolder = recycler.findViewHolderForAdapterPosition(position);
                RecyclerHolderListTasks cvh = (RecyclerHolderListTasks) currentViewHolder;

                ListView listAnswers = (ListView) cvh.getAnswers();
                int numOfAnswers = listAnswers.getAdapter().getCount();
                for (int answerNumber = 0; answerNumber < numOfAnswers; answerNumber++) {
                    String t = (String) listAnswers.getAdapter().getItem(answerNumber);
                    String c = listAnswers.getAdapter().toString();
//                    String c = checkAnswer.isChecked() + "";
//                    TextView textAnswer = (TextView) v.findViewById(R.id.answerItem);
//                    String t = textAnswer.getText().toString();
                }

            }


            System.out.println("!!!!!!!!!!!!!" + numElements);
        }
    }
}
