package com.commonlisper.games;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private String guessedWord;
    private final List<Character> enteredChars;
    private final List<Character> guessedChars;
    private int attemptsCount;

    public Player(String name) {
        this.name = name;
        this.guessedWord = "";
        this.attemptsCount = 1;
        enteredChars = new ArrayList<>();
        guessedChars = new ArrayList<>();
    }

    public String getGuessedWord() {
        return guessedWord;
    }

    public void setGuessedWord(String guessedWord) {
        this.guessedWord = guessedWord;
    }

    public GameRoundInfo makeGameRoundInfo() {
        return new GameRoundInfo(name, attemptsCount, guessedWord, enteredChars, guessedChars);
    }

    public void addEnteredChar(char ch) {
        enteredChars.add(ch);
    }

    public void addGuessedChar(char ch) {
        guessedChars.add(ch);
    }

    public void incrementAttempts() {
        attemptsCount++;
    }

    public List<Character> getEnteredChars() {
        return enteredChars;
    }

    public int getAttemptsCount() {
        return attemptsCount;
    }

    public boolean hasEnteredBefore(char userChar) {
        return enteredChars.contains(userChar);
    }
}
