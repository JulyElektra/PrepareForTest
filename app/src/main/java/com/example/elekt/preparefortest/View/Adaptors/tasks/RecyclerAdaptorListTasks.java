package com.example.elekt.preparefortest.View.Adaptors.tasks;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import com.example.elekt.preparefortest.Model.Task;
import com.example.elekt.preparefortest.R;

import java.util.Collection;

/**
 * Created by elekt on 13.07.2017.
 */

public class RecyclerAdaptorListTasks extends RecyclerView.Adapter<RecyclerHolderListTasks> {
    Collection<Task> tasks;

    public RecyclerAdaptorListTasks(Collection<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public RecyclerHolderListTasks onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tasks_item_in_list, parent, false);
        RecyclerHolderListTasks recyclerHolderListTasks = new RecyclerHolderListTasks(view);
        return recyclerHolderListTasks;
    }

    @Override
    public void onBindViewHolder(RecyclerHolderListTasks holder, int position) {
        holder.numOfQuestions.setText("1");
        holder.questionText.setText("2");

        //TODO
        String[] answers = {"ww", "dd"};
        Context c = null;


        ListAdapter adapter = new ArrayAdapter<String>(holder.itemView.getContext(), R.layout.task_answer_in_list, answers);
        holder.answers.setAdapter(adapter);
        holder.previousQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.nextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.finishTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }
}
