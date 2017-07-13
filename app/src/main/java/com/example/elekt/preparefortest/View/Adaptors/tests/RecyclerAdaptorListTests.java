package com.example.elekt.preparefortest.View.Adaptors.tests;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.elekt.preparefortest.Model.Task;
import com.example.elekt.preparefortest.Model.Test;
import com.example.elekt.preparefortest.Presenter.TasksManager;
import com.example.elekt.preparefortest.R;
import com.example.elekt.preparefortest.View.Tasks;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by elekt on 08.07.2017.
 */

public class RecyclerAdaptorListTests extends RecyclerView.Adapter<RecyclerHolderListTests>  {
    Collection<Test> tests;

    public RecyclerAdaptorListTests(Collection<Test> tests) {
        if (tests  == null) {
            this.tests = new ArrayList<>();
        } else {
            this.tests = tests;
        }
    }

    @Override
    public RecyclerHolderListTests onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.test_item_in_list, parent, false);
        RecyclerHolderListTests recyclerHolderListTests = new RecyclerHolderListTests(v);
        return recyclerHolderListTests;
    }

    @Override
    public void onBindViewHolder(RecyclerHolderListTests holder, int position) {
        Object[] testsArray = tests.toArray();
        final Test test = (Test) testsArray[position];
        holder.name.setText(test.getName());
        holder.programmingLanguage.setText(test.getProgrammingLanguage().getName());
        holder.level.setText(test.getLevel().getName());
        holder.timeBounds.setText(test.getTimeLimitsMin().toString());
        holder.numOfQuestions.setText(test.getTasks().size() + "");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                context.startActivity(new Intent(context, Tasks.class));
                TasksManager.setTasksCurrent(test);
            }
        });

    }



    @Override
    public int getItemCount() {
        return tests.size();
    }

    public void updateList (Collection<Test> tests) {
        if (tests != null) {
            this.tests.clear();
            this.tests.addAll(tests);
            notifyDataSetChanged();
        }
    }


}
