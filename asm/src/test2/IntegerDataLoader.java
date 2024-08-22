package test2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IntegerDataLoader extends AbstractDataLoader<Integer> {

    @Override
    public List<Integer> loadDataToArrayList(String filePath) {
        List<Integer> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                for (String value : line.split("\\s+")) {
                    list.add(Integer.parseInt(value));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
 
    @Override
    public List<Integer> loadDataToLinkedList(String filePath) {
        List<Integer> list = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                for (String value : line.split("\\s+")) {
                    list.add(Integer.parseInt(value));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
