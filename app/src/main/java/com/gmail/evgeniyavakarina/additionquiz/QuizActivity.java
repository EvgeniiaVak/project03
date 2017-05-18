package com.gmail.evgeniyavakarina.additionquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {
    private Questioner mQuestioner = new Questioner();
    private TextView mQuestionTextView;
    private RadioGroup mRadioGroup;
    private RadioButton mRadioButton1;
    private RadioButton mRadioButton2;
    private RadioButton mRadioButton3;
    private Button mSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //find views
        mQuestionTextView = (TextView) findViewById(R.id.questionTextView);
        mRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        mSubmitButton = (Button) findViewById(R.id.button);
        mRadioButton1 = (RadioButton) findViewById(R.id.option1);
        mRadioButton2 = (RadioButton) findViewById(R.id.option2);
        mRadioButton3 = (RadioButton) findViewById(R.id.option3);

        //create the first question
        mQuestionTextView.setText(mQuestioner.createQuestion());


    }
}
