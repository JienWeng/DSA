package DSA;

import java.util.Random;

public class LengthComparison extends DataGenerator {

    public static void main(String[] args) {
        final int RECORD_COUNT = 10_000_000; // 10 million records
        final String OUTPUT_DIRECTORY = "data/integers/length/";

        // Create the output directory if it doesn't exist
        new java.io.File(OUTPUT_DIRECTORY).mkdirs();

        // Generate and store records
        int[] shortNumbers = new int[RECORD_COUNT];
        int[] mediumNumbers = new int[RECORD_COUNT];
        int[] longNumbers = new int[RECORD_COUNT];

        generateRecords(shortNumbers, mediumNumbers, longNumbers);

        // Write records to files in the data directory
        writeToFile(shortNumbers, OUTPUT_DIRECTORY + "short_numbers.txt");
        writeToFile(mediumNumbers, OUTPUT_DIRECTORY + "medium_numbers.txt");
        writeToFile(longNumbers, OUTPUT_DIRECTORY + "long_numbers.txt");
    }

    // Method to generate records
    private static void generateRecords(int[] shortNumbers, int[] mediumNumbers, int[] longNumbers) {
        Random random = new Random();

        for (int i = 0; i < shortNumbers.length; i++) {
            shortNumbers[i] = random.nextInt(10); // Short (1 digit)
            mediumNumbers[i] = 1000 + random.nextInt(9000); // Medium (4 digits)
            longNumbers[i] = generateNineDigitInt(random); // Long (9 digits)
        }
    }

    // Method to generate a 9-digit random number
    private static int generateNineDigitInt(Random random) {
        return 100_000_000 + random.nextInt(900_000_000);
    }
}
