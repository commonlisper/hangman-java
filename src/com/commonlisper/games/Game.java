package com.commonlisper.games;

import java.util.ArrayList;

class Game {
    private final WordProvider wordProvider;
    private final CUIMenu menu;
    private String word;
    private final int attempts;

    public Game(CUIMenu menu, WordProvider wordProvider, int attemptsCount) {
        this.attempts = attemptsCount;
        this.menu = menu;
        this.wordProvider = wordProvider;
    }

    public void start() {
        menu.showWelcomeMessage();

        while (true) {
            char userInput = menu.requestNewGameOrExit();

            if (userInput == 'y') {
                gameLoop();
            } else if (userInput == 'n') {
                menu.showGoodbyeMessage();
                break;
            }
        }
    }

    private void gameLoop() {
        word = wordProvider.getRandomWord();
        menu.showStartGameMenu();
        Player player = new Player(menu.requestUserName());
        player.setGuessedWord(Words.makeMaskedWord(word, new ArrayList<>()));

        boolean isGameOver = false;
        while (!isGameOver) {
            menu.showCurrentGameStatus(player.makeGameRoundInfo());

            newGameRound(player);

            player.setGuessedWord(Words.makeMaskedWord(word, player.getEnteredChars()));

            isGameOver = isGuessedWord(word, player.getGuessedWord()) || isAttemptsEnded(player.getAttemptsCount());
        }

        if (isAttemptsEnded(player.getAttemptsCount())) {
            menu.showLostMessage();
            menu.showGameStatistic(word, player.makeGameRoundInfo());
        } else if (isGuessedWord(word, player.getGuessedWord())) {
            menu.showWinMessage();
            menu.showGameStatistic(word, player.makeGameRoundInfo());
        }
    }

    private void newGameRound(Player player) {
        while (true) {
            char userChar = menu.requestUserChar();

            if (player.hasEnteredBefore(userChar)) {
                menu.showHasEnteredBeforeMessage(userChar);
            } else {
                player.addEnteredChar(userChar);

                if (isGuessedChar(word, userChar)) {
                    player.addGuessedChar(userChar);
                } else {
                    player.incrementAttempts();
                }

                break;
            }
        }
    }

    private boolean isAttemptsEnded(int attemptsCount) {
        return attemptsCount > attempts;
    }

    private boolean isGuessedChar(String word, char userChar) {
        return word.indexOf(userChar) != -1;
    }

    private boolean isGuessedWord(String word, String guessWord) {
        return word.equalsIgnoreCase(guessWord);
    }
}
