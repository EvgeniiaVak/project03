package com.gmail.evgeniyavakarina.additionquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    private Questioner mQuestioner = new Questioner();
    private TextView mQuestionTextView;
    private RadioGroup mRadioGroup;
    private Button mSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //find views
        mQuestionTextView = (TextView) findViewById(R.id.questionTextView);
        mRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        mSubmitButton = (Button) findViewById(R.id.button);

        //create the first question
        upDateViews();

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check if answer was selected
                if(mRadioGroup.getCheckedRadioButtonId() != -1) {
                    RadioButton radioButton = (RadioButton) findViewById(mRadioGroup.getCheckedRadioButtonId());
                    int answer = Integer.parseInt(radioButton.getText().toString());

                    //check if the answer was correct
                    if (mQuestioner.isChoiceCorrect(answer)) {
                        Toast.makeText(QuizActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                        upDateViews();
                        mRadioGroup.clearCheck();
                    } else {
                        Toast.makeText(QuizActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(QuizActivity.this, "Select an answer", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
    * get data from Questioner and update the views with it
    */
    private void upDateViews() {
        mQuestionTextView.setText(mQuestioner.createQuestion());
        int[] answers = mQuestioner.generateAnswers();
        for (int i = 0; i < answers.length; i++) {
            View view = mRadioGroup.getChildAt(i);
            if (view instanceof RadioButton) {
                RadioButton radioButton = (RadioButton) view;
                radioButton.setText(String.valueOf(answers[i]));
            }
        }
    }
}
