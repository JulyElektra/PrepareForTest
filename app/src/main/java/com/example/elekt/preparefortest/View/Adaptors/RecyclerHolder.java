package com.example.elekt.preparefortest.View.Adaptors;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.elekt.preparefortest.R;

/**
 * Created by elekt on 08.07.2017.
 */

public class RecyclerHolder extends RecyclerView.ViewHolder {
    TextView name;
    TextView level;
    TextView programmingLanguage;
    TextView timeBounds;
    TextView numOfQuestions;

    public RecyclerHolder(View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.testNameTestList);
        level = (TextView) itemView.findViewById(R.id.testLevelTestList);
        programmingLanguage = (TextView) itemView.findViewById(R.id.testPrLanguageTestList);
        timeBounds = (TextView) itemView.findViewById(R.id.testTimeBoundsTestList);
        numOfQuestions = (TextView) itemView.findViewById(R.id.testNumOfQuestionsTestList);
    }


}
