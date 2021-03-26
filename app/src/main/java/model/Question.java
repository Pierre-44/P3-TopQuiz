package model;

import java.util.List;

/**
 * Created by pmeignen on 23/03/2021.
 */
public class Question {

    private String mQuestion;
    private List<String> mQuestionChoiceList;
    private int mQuestionAnswerIndex;

    public Question(String question, List<String> questionChoiceList, int questionAnswerIndex) {
        this.setQuestion(question);
        this.QuestionChoiceList(questionChoiceList);
        this.QuestionAnswerIndex(questionAnswerIndex);
    }

    private int QuestionAnswerIndex(int questionAnswerIndex) {
        return questionAnswerIndex;
    }

    private List<String> QuestionChoiceList(List<String> questionChoiceList) {
        return questionChoiceList;
    }

    private void setQuestion(String question) {
        mQuestion = question;
    }

    public String getQuestion() {
        return mQuestion;
    }

    public List<String> getChoiceList() {
        return mQuestionChoiceList;
    }

    public void setQuestionChoiceList(List<String> questionChoiceList) {
        mQuestionChoiceList = questionChoiceList;
    }

    public void setQuestionAnswerIndex(int questionAnswerIndex) {
        mQuestionAnswerIndex = questionAnswerIndex;
    }

    public int getAnswerIndex() {
        return mQuestionAnswerIndex;
    }


}

