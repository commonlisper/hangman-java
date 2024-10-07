package com.commonlisper.games;

import java.util.List;

public class Words {
    public static String makeMaskedWord(String word, List<Character> enteredChars) {
        StringBuilder userWord = new StringBuilder();

        if (enteredChars.isEmpty()) {
            return "-".repeat(word.length());
        }

        for (char ch : word.toCharArray()) {
            if (!enteredChars.contains(ch)) {
                userWord.append('-');
                continue;
            }

            userWord.append(ch);
        }

        return userWord.toString();
    }
}
