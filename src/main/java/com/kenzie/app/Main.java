package com.kenzie.app;

// import necessary libraries
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.Math;
import java.util.Scanner;

public class Main {
    /* Java Fundamentals Capstone project:
       - Define as many variables, properties, and methods as you decide are necessary to
       solve the program requirements.
       - You are not limited to only the class files included here
       - You must write the HTTP GET call inside the CustomHttpClient.sendGET(String URL) method
         definition provided
       - Your program execution must run from the main() method in Main.java
       - The rest is up to you. Good luck and happy coding!

     */

    public static String getAnswerTitle(String url) throws JsonProcessingException {
        String jsonString = CustomHttpClient.sendGET(url);
        ObjectMapper objectMapper = new ObjectMapper();
        CluesDTO clue = objectMapper.readValue(jsonString, CluesDTO.class);

        return clue.getAnswer();
    }

    public static String getQuestion(String url) throws JsonProcessingException {
        String jsonString = CustomHttpClient.sendGET(url);
        ObjectMapper objectMapper = new ObjectMapper();
        CluesDTO clue = objectMapper.readValue(jsonString, CluesDTO.class);

        return clue.getQuestion();
    }

    public static String getCategoryTitle(String url) throws JsonProcessingException {
        String jsonString = CustomHttpClient.sendGET(url);
        ObjectMapper objectMapper = new ObjectMapper();
        CluesDTO clue = objectMapper.readValue(jsonString, CluesDTO.class);

        return clue.getCategory().getTitle();
    }

    public static String getRandomClueURL() {
        int max = 100;
        int min = 1;
        int range = max - min + 1;

        int rand = (int) (Math.random() * range) + min;
        return questionsURL + "/" + rand;
    }

    public static final String questionsURL = "https://jservice.kenzie.academy/api/clues";

    public static void main(String[] args) throws JsonProcessingException {
        //Write main execution code here
        int totalScore = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("\n***** Welcome! Let's play some trivia! *****");
        System.out.println();
        for (int i = 0; i < 10; i++) {
            String clueURL = getRandomClueURL();
            System.out.println("Category: " + getCategoryTitle(clueURL) + "\nQuestion: " + getQuestion(clueURL));
            String userAnswer = sc.nextLine();
            if (userAnswer.equalsIgnoreCase(getAnswerTitle(clueURL))) {
                totalScore++;
                System.out.println("[You are correct!]");
                System.out.println("TOTAL SCORE: " + totalScore);
                System.out.println();
            } else {
                System.out.println("[That is not correct]");
                System.out.println("Correct Answer: " + getAnswerTitle(clueURL));
                System.out.println("TOTAL SCORE: " + totalScore);
                System.out.println();
            }
        }

        System.out.println("Congratulations! You got " + totalScore + "/10 questions correct!");
        System.out.println("Your total score is " + totalScore + " point(s)");
    }
}


