package com.las.learn.designpattern.decorator;

import java.io.*;

public class InputTest {
    public static void main(String[] args) {
        int c;
        try {
            InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("/home/las/IdeaProjects/java-learn/src/main/java/com/las/learn/designpattern/decorator/test.txt")));

            while ((c = in.read()) > 0) {
                System.out.print((char) c);
            }
            in.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
