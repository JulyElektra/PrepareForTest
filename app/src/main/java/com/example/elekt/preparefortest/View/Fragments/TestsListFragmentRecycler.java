package com.example.elekt.preparefortest.View.Fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.elekt.preparefortest.Model.Test;
import com.example.elekt.preparefortest.Presenter.TestsManager;
import com.example.elekt.preparefortest.R;
import com.example.elekt.preparefortest.View.Adaptors.tests.RecyclerAdaptorListTests;

import java.util.Collection;

/**
 * Created by elekt on 08.07.2017.
 */

public class TestsListFragmentRecycler extends Fragment {
    RecyclerView recyclerView;
    RecyclerAdaptorListTests adaptor;
    RecyclerView.LayoutManager manager;
    Context context;
    View view;

    public RecyclerAdaptorListTests getAdaptor() {
        return adaptor;
    }

    //    Collection<Test> tests;
//
//    public void setTests(Collection<Test> tests) {
//        this.tests = tests;
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tests_list_fragment_recycler, container, false);
        context = view.getContext();
        Collection<Test> tests = TestsManager.getTestsCurrent();
        if (tests != null) {
            adaptor = new RecyclerAdaptorListTests(tests);
        }
//        adaptor.notifyDataSetChanged();
        manager = new LinearLayoutManager(this.getActivity());
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerForTestsList);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adaptor);
        return view;
    }


}
