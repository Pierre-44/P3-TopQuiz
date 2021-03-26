package controller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
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
    private Question question;

    private int mScore;
    private int mNumberOfQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mQuestionBank = this.generateQuestions();

        // initialisation Score
        mScore = 0;

        // nombre de questions à poser
        mNumberOfQuestion = 4;

        // branchement des widgets
        mQuestionTextView = (TextView) findViewById(R.id.activity_game_question_text);
        mAnswerBtn1 = (Button) findViewById(R.id.activity_game_answer1_btn);
        mAnswerBtn2 = (Button) findViewById(R.id.activity_game_answer2_btn);
        mAnswerBtn3 = (Button) findViewById(R.id.activity_game_answer3_btn);
        mAnswerBtn4 = (Button) findViewById(R.id.activity_game_answer4_btn);

        // identifiaction des boutons et de leurs tag
        mAnswerBtn1.setTag(0);
        mAnswerBtn2.setTag(1);
        mAnswerBtn3.setTag(2);
        mAnswerBtn4.setTag(3);

        mAnswerBtn1.setOnClickListener(this);
        mAnswerBtn2.setOnClickListener(this);
        mAnswerBtn3.setOnClickListener(this);
        mAnswerBtn4.setOnClickListener(this);

        mCurrentQuestion = mQuestionBank.getQuestion();
        this.displayQuestion(mCurrentQuestion);



    }

    public void onClick(View v) {
        int responseIndex = (int) v.getTag(); //retourner l'index du clic et forcer le type de retour en int pour getTag

        if (responseIndex == mCurrentQuestion.getAnswerIndex()) {
            // bonne réponse
            Toast.makeText(this, "bonne réponse ", Toast.LENGTH_SHORT).show();
            mScore++;
        } else {
            // mauvaise réponse
            Toast.makeText(this, "mauvaise réponse ", Toast.LENGTH_SHORT).show();
        }

        if (--mNumberOfQuestion == 0){
            // Fin du Jeu si nombre de question restant = 0
            endGame();
        } else {
            mCurrentQuestion = mQuestionBank.getQuestion();
            displayQuestion(mCurrentQuestion);
        }
    }

    private void endGame() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Bien jouer!")
                .setMessage("ton score est de " + mScore)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Fin de l'Activity
                Intent intent = new Intent();
                finish();
            }
        })
                .setCancelable(false)
                .create()
                .show();
    }

    private void displayQuestion(Question currentQuestion) {
        mQuestionTextView.setText(question.getQuestion());
        mAnswerBtn1.setText(question.getChoiceList().get(0));
        mAnswerBtn1.setText(question.getChoiceList().get(1));
        mAnswerBtn1.setText(question.getChoiceList().get(2));
        mAnswerBtn1.setText(question.getChoiceList().get(3));
    }

    private QuestionBank generateQuestions() {
        Question question1 = new Question("Quiest le créateur d'Android?",
                Arrays.asList("Andy Rubin", "Steve Wozniak","Jake Wharton","Paul Smith"),
                0);
        Question question2 = new Question("Qunad le premier homme à marcher sur la lune?",
                Arrays.asList("1958","1962","1967","1969"),
                3);
        Question question3 = new Question("Quel est le numéro de la maison des simpsons?",
                Arrays.asList("42","101","666","742"),
                3);
        Question question4 = new Question("quelle ville à acceulli l'explosition universelle de 1900?",
                Arrays.asList("Paris","Londres","New York","Tokyo"),
                0);
        Question question5 = new Question("quel est la plus grosse planette du systeme solaire?",
                Arrays.asList("la terre","jupiter","saturn","le soleil"),
                1);

        return new QuestionBank(Arrays.asList(question1, question2, question3, question3, question4, question5 ));
    }

    public void setCurrentQuestion(Question currentQuestion) {
        mCurrentQuestion = currentQuestion;
    }
}
