package DSA;

import java.util.Random;

public class NumberOfRecords extends DataGenerator{

    public static void main(String[] args) {
        final String OUTPUT_DIRECTORY = "data/integers/numberOfRecords/";

        // Generate datasets with varying numbers of 9-digit records
        for (int i = 1; i <= 10; i++) {
            int recordCount = i * 1_000_000; // Generate 1M to 10M records
            String fileName = OUTPUT_DIRECTORY + "numbersofrecords_" + recordCount + ".txt";
            int[] records = generateRecords(recordCount);
            writeToFile(records, fileName);
        }
    }

 // Method to generate an array of 9-digit integers
    private static int[] generateRecords(int recordCount) {
        Random random = new Random();
        int[] records = new int[recordCount];

        for (int i = 0; i < recordCount; i++) {
            records[i] = generateNineDigitInt(random);
        }

        return records;
    }

    // Method to generate a 9-digit integer
    private static int generateNineDigitInt(Random random) {
        return 100_000_000 + random.nextInt(900_000_000);
    }
}
