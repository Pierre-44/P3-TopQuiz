package controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.pierre44.topquiz.R;

public class GameActivity extends AppCompatActivity {

    private TextView mQuestionTextView;
    private Button mAnswerBtn1;
    private Button mAnswerBtn2;
    private Button mAnswerBtn3;
    private Button mAnswerBtn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mQuestionTextView = (TextView) findViewById(R.id.activity_game_question_text);
        mAnswerBtn1 = (Button) findViewById(R.id.activity_game_answer1_btn);
        mAnswerBtn2 = (Button) findViewById(R.id.activity_game_answer2_btn);
        mAnswerBtn3 = (Button) findViewById(R.id.activity_game_answer3_btn);
        mAnswerBtn4 = (Button) findViewById(R.id.activity_game_answer4_btn);

    }
}