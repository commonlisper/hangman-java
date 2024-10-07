package com.commonlisper.games;

import com.commonlisper.games.exceptions.ValidatorException;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.Scanner;
import java.util.Set;

public class CUIMenu {
    private final Scanner scanner;
    private final String placeholder = "-".repeat(15);

    public CUIMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    private <T> T getUserInput(String message,
                               String errorValidateMessage,
                               Function<String, T> parser,
                               Predicate<T> validator) {
        System.out.print(message + " ");

        while (true) {
            String inputString = scanner.nextLine().strip();

            T parsedInput;
            try {
                parsedInput = parser.apply(inputString);

                if (validator.test(parsedInput)) {
                    return parsedInput;
                } else {
                    throw new ValidatorException(errorValidateMessage);
                }
            } catch (Exception e) {
                System.err.println(" Error: " + e.getMessage());
            }
        }
    }

    public char requestNewGameOrExit() {
        final Set<Character> validOptions = Set.of('y', 'n');

        return getUserInput("Do you want to game or to exit? (y/n)",
                "Must be a character `y` or `n`",
                input -> input.toLowerCase().charAt(0),
                validOptions::contains);
    }

    public String requestUserName() {
        return getUserInput("Please, enter your name:",
                "Name cannot be blank",
                input -> input,
                input -> !input.isBlank());
    }

    public char requestUserChar() {
        return getUserInput("Please, enter your char:",
                "Not a char, re-enter",
                input -> input.charAt(0),
                Character::isLetter);
    }

    public void showCurrentGameStatus(GameRoundInfo roundInfo) {
        System.out.println(placeholder);
        System.out.println("Attempt №" + roundInfo.getAttemptsCount());
        System.out.println("Your word was => " + roundInfo.getGuessedWord());
        System.out.println("Letters you've guessed => " + roundInfo.getGuessedChars());
        System.out.println("Letters you've entered => " + roundInfo.getEnteredChars());
        System.out.println(GameState.getStateByAttempts(roundInfo.getAttemptsCount() - 1));
        System.out.println(placeholder);
    }

    public void showGameStatistic(String targetWord, GameRoundInfo roundInfo) {
        System.out.println(placeholder);
        System.out.println("`" + roundInfo.getUserName() + "`");
        System.out.println("The target word => " + targetWord);
        System.out.println("Your word       => " + roundInfo.getGuessedWord());
        System.out.println("Letters you've entered => " + roundInfo.getEnteredChars());
        System.out.println("Letters you've guessed => " + roundInfo.getGuessedChars());
        System.out.println(placeholder);
    }

    public void showWelcomeMessage() {
        System.out.println("Welcome to the Hangman!\n");
    }

    public void showGoodbyeMessage() {
        System.out.println("Goodbye! Have a nice day!\n");
    }

    public void showStartGameMenu() {
        System.out.println("Starting new game!!!");
    }

    public void showHasEnteredBeforeMessage(char userChar) {
        System.out.println("`" + userChar + "` character has been entered before, please try again");
    }

    public void showLostMessage() {
        System.out.println("Sorry, you are lost...");
        System.out.println("You can try again");
    }

    public void showWinMessage() {
        System.out.println("You are win! Congrats!");
    }
}
