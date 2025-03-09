package com.assignment2;

import java.util.Scanner;

public class Assignment2 {
    private static Boolean wordContainsLetter(String word, char letter) {
        return word.indexOf(letter) != 1;
    }
    private static Boolean wordContainsString(String word, String pattern) {
        return word.contains(pattern);
    }
    private static void guessWordWithLetters(English english, int length, String letters) {
        english.words.stream().filter(word -> word.length() == length).forEach(word -> {
            Boolean isWordContainsLetter = true;
            for (char letter : letters.toCharArray()) {
                if (!wordContainsLetter(word, letter)) {
                    isWordContainsLetter = false;
                    break;
                }
            }
            if (isWordContainsLetter) {
                System.out.println(word);
            }
        });
    }
    private static void guessWordWithPattern(English english, int length, String pattern) {
        english.words.stream().filter(word -> word.length() == length).filter(word -> wordContainsString(word, pattern)).forEach(System.out::println);
    }
    private static void systemExit() {
        System.out.println("Invalid input");
        System.exit(0);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        English english = new English();
        System.out.println("How many letters are in the word? ");
        int length = Integer.parseInt(sc.nextLine());
        if (length < 1) {
            systemExit();
        }
        System.out.println("\nDo you want me to look for letters or a pattern?\n1. Letters\n2. Pattern");
        int searchByType = Integer.parseInt(sc.nextLine());
        if (searchByType == 1) {
            System.out.println("What letters are in the word?");
            String letters = sc.nextLine();
            System.out.println("It might be any of these...");
            guessWordWithLetters(english, length, letters);
        } else if (searchByType == 2) {
            System.out.println("What pattern is in the word?");
            String pattern = sc.nextLine();
            System.out.println("It might be any of these...");
            guessWordWithPattern(english, length, pattern);
        } else {
            systemExit();
            sc.close();
        }
    }
}

