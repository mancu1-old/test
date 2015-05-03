package EngineForTests;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class TestMain {
    public static void main(String[] args) throws IOException {
        LinkedList<TestQuestion> quest = null;
        try {
            File myFile = new File("text.txt");
            FileReader fileReader = new FileReader(myFile);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            quest = new LinkedList<TestQuestion>();
            while ((line = reader.readLine()) != null) { //начало цикла вопросов
                String line1 = line;
                ArrayList<TestAnswer> answ = new ArrayList<TestAnswer>();
                while ((line = reader.readLine()) != null && !line.equals("#")) {//начало цикла ответов
                    TestAnswer a = new TestAnswer(line);
                    answ.add(a);
                }
                TestQuestion q = new TestQuestion(line1, answ);
                quest.add(q);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        if (quest != null) {
            TestUserAnswers usAn = new TestUserAnswers();
            System.out.println("введи имя");
            usAn.setNameRead(usAn.read());
            usAn.inputInFile();
            for(TestQuestion quesNumIList : quest) {
                int pozition = 0;
                quesNumIList.textOutput();
                quesNumIList.outputVariantsResponse();
                boolean faithfulResponse = quesNumIList.check(usAn.read());
                System.out.println(faithfulResponse);
                pozition++;
                usAn.inputInFile(pozition, faithfulResponse);
            }
        }
        else System.out.println("Нет вопросов");

    }
}