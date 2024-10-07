package com.commonlisper.games;

import java.util.List;
import java.util.Random;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WordFileProvider implements WordProvider {

    private final List<String> words;

    public WordFileProvider(String path) throws IOException {
        this.words = Files.readAllLines(Path.of(path));
    }

    public String getRandomWord() {
        words.removeIf(el -> el.length() < 4);

        Random random = new Random();
        int randomIndex = random.ints(0, words.size()).findAny().getAsInt();

        return words.get(randomIndex);
    }
}
