package model;


import java.util.List;
import static java.util.Collections.shuffle;

/**
 * Created by pmeignen on 23/03/2021.
 */
public class QuestionBank {
    private List<Question> mQuestionList;
    private int mNextQuestionIndex;

    public QuestionBank(List<Question> questionList) {
        mQuestionList = questionList;

        // mellanger la questionList

        shuffle(mQuestionList);
        mNextQuestionIndex = 0;
    }

    public Question getQuestion () {
        // s'assurer qu'une fois la fin de liste de question atteinte on retourne au debut de la liste
        if (mNextQuestionIndex == mQuestionList.size());
            mNextQuestionIndex = 0;

            return mQuestionList.get(mNextQuestionIndex++);
    }
}


