package com.commonlisper.games;

import java.util.List;

public class GameRoundInfo {

    private final String userName;

    public String getUserName() {
        return userName;
    }

    private final int attemptsCount;

    public int getAttemptsCount() {
        return attemptsCount;
    }

    private final String guessedWord;

    public String getGuessedWord() {
        return guessedWord;
    }

    private final List<Character> enteredChars;

    public List<Character> getEnteredChars() {
        return enteredChars;
    }

    private final List<Character> guessedChars;

    public List<Character> getGuessedChars() {
        return guessedChars;
    }

    public GameRoundInfo(String userName,
                         int attemptsCount,
                         String guessedWord,
                         List<Character> enteredChars,
                         List<Character> guessedChars) {
        this.userName = userName;
        this.attemptsCount = attemptsCount;
        this.guessedWord = guessedWord;
        this.enteredChars = enteredChars;
        this.guessedChars = guessedChars;
    }
}
