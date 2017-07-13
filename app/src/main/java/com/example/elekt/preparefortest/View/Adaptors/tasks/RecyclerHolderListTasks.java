package com.example.elekt.preparefortest.View.Adaptors.tasks;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.elekt.preparefortest.R;

/**
 * Created by elekt on 13.07.2017.
 */

public class RecyclerHolderListTasks extends RecyclerView.ViewHolder {
    TextView numOfQuestions;
    TextView questionText;
    ListView answers;
    Button previousQuestion;
    Button nextQuestion;
    Button finishTest;


    public RecyclerHolderListTasks(View itemView) {
        super(itemView);
        numOfQuestions = (TextView) itemView.findViewById(R.id.questionCounter);
        questionText = (TextView) itemView.findViewById(R.id.questionText);
        answers = (ListView) itemView.findViewById(R.id.listAnswers);
        previousQuestion = (Button) itemView.findViewById(R.id.buttonPreviousQuestion);
        nextQuestion = (Button) itemView.findViewById(R.id.buttonNextQuestion);
        finishTest = (Button) itemView.findViewById(R.id.buttonFinishTest);

    }
}
