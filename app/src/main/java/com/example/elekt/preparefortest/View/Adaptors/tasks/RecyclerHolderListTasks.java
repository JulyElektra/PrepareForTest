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
    private TextView numOfQuestion;
    private TextView questionText;
    private ListView answers;
    private Button previousQuestion;
    private Button nextQuestion;
//    private Button finishTest;
    private TextView codeChunks;
    private TextView idTask;


    public RecyclerHolderListTasks(View itemView) {
        super(itemView);
        numOfQuestion = (TextView) itemView.findViewById(R.id.questionCounter);
        questionText = (TextView) itemView.findViewById(R.id.questionText);
        answers = (ListView) itemView.findViewById(R.id.listAnswers);
        previousQuestion = (Button) itemView.findViewById(R.id.buttonPreviousQuestion);
        nextQuestion = (Button) itemView.findViewById(R.id.buttonNextQuestion);
//        finishTest = (Button) itemView.findViewById(R.id.buttonFinishTest);
        codeChunks = (TextView) itemView.findViewById(R.id.codeChunks);
        idTask = (TextView) itemView.findViewById(R.id.idTask);

    }

    public TextView getIdTask() {
        return idTask;
    }

    public TextView getCodeChunks() {
        return codeChunks;
    }

    public TextView getNumOfQuestion() {
        return numOfQuestion;
    }

    public TextView getQuestionText() {
        return questionText;
    }

    public ListView getAnswers() {
        return answers;
    }

    public Button getPreviousQuestion() {
        return previousQuestion;
    }

    public Button getNextQuestion() {
        return nextQuestion;
    }

//    public Button getFinishTest() {
//        return finishTest;
//    }


    public void setNumOfQuestion(TextView numOfQuestion) {
        this.numOfQuestion = numOfQuestion;
    }

    public void setQuestionText(TextView questionText) {
        this.questionText = questionText;
    }

    public void setAnswers(ListView answers) {
        this.answers = answers;
    }

    public void setPreviousQuestion(Button previousQuestion) {
        this.previousQuestion = previousQuestion;
    }

    public void setNextQuestion(Button nextQuestion) {
        this.nextQuestion = nextQuestion;
    }

//    public void setFinishTest(Button finishTest) {
//        this.finishTest = finishTest;
//    }
}
