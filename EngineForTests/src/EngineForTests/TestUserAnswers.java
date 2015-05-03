package EngineForTests;

import java.io.*;

public class TestUserAnswers {
private String nameRead;
    void setNameRead(String read){nameRead = read;}
    void inputInFile() throws  IOException {
        File resultFile = new File("result.txt");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(resultFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedWriter writer = new BufferedWriter(fileWriter);
        writer.write(nameRead);
        writer.newLine();
        writer.flush();
        writer.close();
    }
    void inputInFile(int pozition, boolean bolUs) throws  IOException  {
        File resultFile = new File("result.txt");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(resultFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedWriter writer = new BufferedWriter(fileWriter);
        writer.newLine();
        writer.write(pozition + " " + bolUs);
        writer.newLine();
    }
    String read() throws IOException {
        BufferedReader text = new BufferedReader(new InputStreamReader(System.in));
        return text.readLine();
    }
}