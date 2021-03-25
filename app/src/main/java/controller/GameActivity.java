package controller;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.pierre44.topquiz.R;
import java.util.Arrays;
import model.Question;
import model.QuestionBank;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mQuestionTextView;
    private Button mAnswerBtn1;
    private Button mAnswerBtn2;
    private Button mAnswerBtn3;
    private Button mAnswerBtn4;

    private QuestionBank mQuestionBank;
    private Question mCurrentQuestion;


    @Override
    public void onClick(View v) {
        int responseIndex = (int) v.getTag(); //forcer le retour en int pour getTag

        if (responseIndex == mCurrentQuestion.getAnswerIndex()) {
            // bonne reponse
            Toast.makeText(this, "bonne reponse ", Toast.LENGTH_SHORT).show();
        } else {
            // mauvaise réponse
            Toast.makeText(this, "mauvaise réponse ", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mQuestionBank = this.generateQuestions();

        // branchement des widgets
        mQuestionTextView = (TextView) findViewById(R.id.activity_game_question_text);
        mAnswerBtn1 = (Button) findViewById(R.id.activity_game_answer1_btn);
        mAnswerBtn2 = (Button) findViewById(R.id.activity_game_answer2_btn);
        mAnswerBtn3 = (Button) findViewById(R.id.activity_game_answer3_btn);
        mAnswerBtn4 = (Button) findViewById(R.id.activity_game_answer4_btn);


        // identifiaction des boutons
        mAnswerBtn1.setTag(0);
        mAnswerBtn2.setTag(1);
        mAnswerBtn3.setTag(2);
        mAnswerBtn4.setTag(3);


    }

    private QuestionBank generateQuestions() {
        Question question1 = new Question("Who is the creator of Android?",
                Arrays.asList("Andy Rubin", "Steve Wozniak","Jake Wharton","Paul Smith"),
                0);
        Question question2 = new Question("When did the first man land on the moon?",
                Arrays.asList("1958","1962","1967","1969"),
                3);
        Question question3 = new Question("What is the house number of The Simpsons?",
                Arrays.asList("42","101","666","742"),
                3);
        return new QuestionBank(Arrays.asList(question1, question2, question3));
    }

}
