package DSA;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public abstract class DataGenerator {
	
	   protected static void writeToFile(int[] data, String filePath) {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
	            for (int i : data) {
	                writer.write(i + "\n");
	            }
	            System.out.println(filePath +" saved to file.");
	        } catch (IOException e) {
	        }
	    }
	   
	   protected static void writeToFile(String[] data, String filePath) {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
	            for (String i : data) {
	                writer.write(i + "\n");
	            }
	            System.out.println(filePath +"saved to file.");
	        } catch (IOException e) {
	        }
	    }

}
