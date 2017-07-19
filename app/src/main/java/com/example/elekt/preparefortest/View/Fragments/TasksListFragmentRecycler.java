package com.example.elekt.preparefortest.View.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.elekt.preparefortest.Model.Task;
import com.example.elekt.preparefortest.Presenter.TasksManager;
import com.example.elekt.preparefortest.R;
import com.example.elekt.preparefortest.View.Adaptors.tasks.RecyclerAdaptorListTasks;
import com.example.elekt.preparefortest.View.Adaptors.tasks.RecyclerHolderListTasks;

import java.util.Collection;

/**
 * Created by elekt on 13.07.2017.
 */

public class TasksListFragmentRecycler extends Fragment {
    RecyclerView recyclerView;
    private RecyclerHolderListTasks holder;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.tasks_recycler_layout, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.taskRecyclerView);
        Collection<Task> tasks = TasksManager.getTasksCurrent();
        if (tasks != null) {
            RecyclerAdaptorListTasks adaptor = new RecyclerAdaptorListTasks(tasks);
            recyclerView.setAdapter(adaptor);

        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity(),  LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setHasFixedSize(true);


        return view;
    }
}
