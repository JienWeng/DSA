package DSA;

import java.util.Random;


public class StateOfData extends DataGenerator {

	public static void main(String[] args) {
        final int DATA_SIZE = 10000000; // 10 million
		final String OUTPUT_DIRECTORY = "data/integers/stateOfData/";
		
        int[] partiallySorted = generateRandomData(DATA_SIZE, 0.50); // 50% shuffled
        int[] nearlySorted = generateRandomData(DATA_SIZE, 0.05); // 5% shuffled
        int[] random = generateRandomData(DATA_SIZE, 1); // 5% shuffled
        
        // Save the datasets to files
        writeToFile(partiallySorted, OUTPUT_DIRECTORY+"partiallySorted.txt");
        writeToFile(nearlySorted, OUTPUT_DIRECTORY+"nearlySorted.txt");
        writeToFile(random, OUTPUT_DIRECTORY+"random.txt");
    }

    public static int[] generateRandomData(int size, double shuffleFraction) {
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = i;
        }

        // Shuffle a small fraction of the array
        Random rand = new Random();
        for (int i = 0; i < (int) (size * shuffleFraction); i++) {
            int index1 = rand.nextInt(size);
            int index2 = rand.nextInt(size);
            int temp = data[index1];
            data[index1] = data[index2];
            data[index2] = temp;
        }

        return data;
    }
    

}
