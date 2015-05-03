package EngineForTests;


public class TestAnswer {
    private String possibleAnswers;
    private boolean correct;


    public TestAnswer(String line) {
        if (line.charAt(0) == '+') correct = true;
        else if (line.charAt(0) == '-') correct = false;
        else {
            System.out.println("не указана верность ответа");
            correct = false;
        }
        possibleAnswers = line.substring(1);
    }
    String getPossibleAnswers() {
        return possibleAnswers;
    }

    boolean getCorrect() {
        return correct;
    }
}
