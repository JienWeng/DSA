package test2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StringDataLoader extends AbstractDataLoader<String> { 

    @Override
    public List<String> loadDataToArrayList(String filePath) {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                for (String value : line.split("\\s+")) {
                    list.add(value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<String> loadDataToLinkedList(String filePath) {
        // This method is not applicable for strings as per current requirement
        throw new UnsupportedOperationException("LinkedList is not supported for strings.");
    }
}
