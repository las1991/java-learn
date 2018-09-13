package com.las.learn.lambda;

import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCount {
    public static void main(String[] args) throws FileNotFoundException {
        InputStream in = new FileInputStream("/home/las/ideaProject/java-learn/src/main/java/com/las/learn/lambda/wordCount.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        br.lines()
                .flatMap(x -> Stream.of(x.split(" ")))
                .collect(Collectors.groupingBy(x -> x))
                .forEach((x, y) -> System.out.println(x + ":" + y.size()));
    }
}
