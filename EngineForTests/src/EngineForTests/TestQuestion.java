package EngineForTests;

import java.util.ArrayList;

public class TestQuestion {
    private String qText;
    private ArrayList<TestAnswer> answers;

    public TestQuestion(String line, ArrayList<TestAnswer> answ) {
        qText = line;
        answers = answ;
    }

    String getQText() {
        return qText;
    }

    ArrayList<TestAnswer> getAnswers() {
        return answers;
    }

    void textOutput() {
        System.out.println(qText);
    }

    void outputVariantsResponse() {
        for (TestAnswer ans : answers) System.out.println(ans.getPossibleAnswers());
    }

    Boolean check(String userAnswers) {
        int position;
        try {
            position = Integer.valueOf(userAnswers) - 1;
            return answers.get(position).getCorrect();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("неправильный тип ответа");
            return false;

        }
    }
}