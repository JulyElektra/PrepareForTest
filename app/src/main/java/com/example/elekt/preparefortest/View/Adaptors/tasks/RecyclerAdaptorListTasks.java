package com.example.elekt.preparefortest.View.Adaptors.tasks;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.elekt.preparefortest.Model.Task;
import com.example.elekt.preparefortest.R;

import java.util.Collection;
import java.util.Map;

/**
 * Created by elekt on 13.07.2017.
 */

public class RecyclerAdaptorListTasks extends RecyclerView.Adapter<RecyclerHolderListTasks> {
    private Collection<Task> tasks;
    private RecyclerHolderListTasks holder;
    private RecyclerView recyclerView;

    public RecyclerHolderListTasks getHolder() {
        return holder;
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public RecyclerAdaptorListTasks(Collection<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public RecyclerHolderListTasks onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tasks_item_in_list,
                parent, false);
        RecyclerHolderListTasks recyclerHolderListTasks = new RecyclerHolderListTasks(view);
        return recyclerHolderListTasks;
    }

    @Override
    public void onBindViewHolder(final RecyclerHolderListTasks holder, int position) {
        this.holder = holder;
        Task currentTask = (Task) tasks.toArray()[position];
        int currentTaskNumber = position + 1;
        holder.getNumOfQuestion().setText(currentTaskNumber + "/" + tasks.size());
        if (currentTaskNumber == 1) {
            holder.getPreviousQuestion().setEnabled(false);
        }
        if (currentTaskNumber == tasks.size()) {
            holder.getNextQuestion().setEnabled(false);
        }
        holder.getQuestionText().setText(currentTask.getQuestion());
        holder.getCodeChunks().setText(currentTask.getCodeChunk());

        Map<String, Boolean> answersMap = currentTask.getPossibleAnswers();
        String[] answers = new String[answersMap.size()];
        currentTask.getPossibleAnswers().keySet().toArray(answers);

        ListAdapter adapter = new ArrayAdapter<String>(holder.itemView.getContext(),
                R.layout.task_answer_in_list, R.id.answerItem, answers);
        holder.getAnswers().setAdapter(adapter);


        holder.getPreviousQuestion().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.scrollToPosition(getCurrentNumber(v) - 1);


            }
        });
        holder.getNextQuestion().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                recyclerView.scrollToPosition(getCurrentNumber(v) + 1);
            }
        });
//        holder.getFinishTest().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }

    private int getCurrentNumber(View v) {
        View vp = (View) v.getParent().getParent();
        String s = ((TextView) vp.findViewById(R.id.questionCounter)).getText().toString();
        int currentNumber = Integer.parseInt(s.split("/")[0]) - 1;
        return currentNumber;
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    @Override
    public void onAttachedToRecyclerView(final RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;

    }


}
