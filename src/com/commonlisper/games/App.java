package com.commonlisper.games;

import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        CUIMenu menu = new CUIMenu(scanner);
        WordFileProvider wordProvider = new WordFileProvider("src/com/commonlisper/games/nouns.txt");
        int attemptsCount = 7;
        Game game = new Game(menu, wordProvider, attemptsCount);

        game.start();

        scanner.close();
    }
}
