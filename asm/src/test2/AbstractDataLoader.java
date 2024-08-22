package test2;

import java.util.List;

public abstract class AbstractDataLoader<T> {
    public abstract List<T> loadDataToArrayList(String filePath);
    public abstract List<T> loadDataToLinkedList(String filePath);
}
