package DSA;

import org.apache.commons.text.RandomStringGenerator;

public class StringLengthComparison extends DataGenerator{
    private static final int RECORD_COUNT = 500_000; // 500,000 records
    private static final String OUTPUT = "data/strings/length/";

    public static void main(String[] args) {
        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange('a', 'z')
                .build();
        
        String[] alphabets = generateRandomStrings(generator, RECORD_COUNT, 1);
        String filePath = OUTPUT + "short.txt";
        writeToFile(alphabets, filePath);
        
        String[] words = generateRandomStrings(generator, RECORD_COUNT, 10); // Example word length
        String wordsFilePath = OUTPUT + "words.txt";
        writeToFile(words, wordsFilePath);
    }

	private static String[] generateRandomStrings(RandomStringGenerator generator, int count, int length) {
        String[] strings = new String[count];
        for (int i = 0; i < count; i++) {
            strings[i] = generator.generate(length);
        }
        return strings;
    }
}
