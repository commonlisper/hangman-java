package com.commonlisper.games;

public class GameState {
    private static final String[] state = {"""
  +---+
  |   |
      |
      |
      |
      |
=========""",
            """
  +---+
  |   |
  O   |
      |
      |
      |
=========""",
            """
  +---+
  |   |
  O   |
  |   |
      |
      |
=========""",
            """
  +---+
  |   |
  O   |
 /|   |
      |
      |
=========""",
            """
  +---+
  |   |
  O   |
 /|\\  |
      |
      |
=========""",
            """
  +---+
  |   |
  O   |
 /|\\  |
 /    |
      |
=========""",
            """
  +---+
  |   |
  O   |
 /|\\  |
 / \\  |
      |
========="""};

    public static String getStateByAttempts(int attemptsCount) {
        if (attemptsCount >= 0 && attemptsCount < state.length) {
            return state[attemptsCount];
        }

        throw new ArrayIndexOutOfBoundsException("index: " + attemptsCount
                + ", state must be in [0.." + (state.length - 1) + "]");
    }
}
