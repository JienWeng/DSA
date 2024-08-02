package DSA;

import java.io.*;
import java.net.URL;
import java.util.*;

public class StringLengthComparison extends DataGenerator {
    private static final int RECORD_COUNT = 500_000; // 500,000 records
    private static final String OUTPUT = "data/strings/length/";
    private static final String DICTIONARY_URL = "https://web.stanford.edu/class/archive/cs/cs106l/cs106l.1102/assignments/dictionary.txt"; 
    
    public static void main(String[] args) {
        List<String> wordList = readWordsFromURL(DICTIONARY_URL);

        if (wordList.isEmpty()) {
            System.err.println("The dictionary file is empty or could not be read.");
            return;
        }

        Random random = new Random();

        // Generate and write single random alphabets
        String[] alphabets = generateRandomAlphabets(random, RECORD_COUNT);
        String alphabetsFilePath = OUTPUT + "short.txt";
        writeToFile(alphabets, alphabetsFilePath);

        // Generate and write random words from the dictionary
        String[] randomWords = generateRandomWords(wordList, random, RECORD_COUNT);
        String randomWordsFilePath = OUTPUT + "words.txt";
        writeToFile(randomWords, randomWordsFilePath);
    }

    private static List<String> readWordsFromURL(String urlString) {
        List<String> wordList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new URL(urlString).openStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                wordList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordList;
    }

    private static String[] generateRandomAlphabets(Random random, int count) {
        String[] alphabets = new String[count];
        for (int i = 0; i < count; i++) {
            if (random.nextBoolean()) {
                alphabets[i] = String.valueOf((char) ('a' + random.nextInt(26)));
            } else {
                alphabets[i] = String.valueOf((char) ('A' + random.nextInt(26)));
            }
        }
        return alphabets;
    }

    private static String[] generateRandomWords(List<String> wordList, Random random, int count) {
        String[] words = new String[count];
        int wordListSize = wordList.size();
        for (int i = 0; i < count; i++) {
            words[i] = wordList.get(random.nextInt(wordListSize));
        }
        return words;
    }
}
