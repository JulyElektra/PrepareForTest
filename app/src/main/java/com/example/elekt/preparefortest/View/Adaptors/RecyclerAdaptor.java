package com.example.elekt.preparefortest.View.Adaptors;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.elekt.preparefortest.Model.Test;
import com.example.elekt.preparefortest.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by elekt on 08.07.2017.
 */

public class RecyclerAdaptor extends RecyclerView.Adapter<RecyclerHolder>  {
    Collection<Test> tests;

    public RecyclerAdaptor(Collection<Test> tests) {
        if (tests  == null) {
            this.tests = new ArrayList<>();
        } else {
            this.tests = tests;
        }
    }

    @Override
    public RecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.test_item_in_list, parent, false);
        RecyclerHolder recyclerHolder = new RecyclerHolder(v);
        return recyclerHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerHolder holder, int position) {
        Object[] testsArray = tests.toArray();
        Test test = (Test) testsArray[position];
        holder.name.setText(test.getName());
        holder.programmingLanguage.setText(test.getProgrammingLanguage().getName());
        holder.level.setText(test.getLevel().getName());
        holder.timeBounds.setText(test.getTimeLimitsMin().toString());
        holder.numOfQuestions.setText(test.getTasks().size() + "");

    }

    @Override
    public int getItemCount() {
        return tests.size();
    }
}
