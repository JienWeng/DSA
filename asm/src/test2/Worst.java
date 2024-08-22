package test2;
import java.io.IOException;
import java.util.*;

//JUST FOR TESTING
public class Worst {
	public static void main(String[] args) {
        // Example data
        List<Integer> ori = new ArrayList<>(Arrays.asList(12, 11, 13, 5, 6, 7));
        
        List<Integer> arrayList=new ArrayList<>(ori);
        LinkedList<Integer> linkedList = new LinkedList<>(ori);

        for (int i = 0; i < 10; i++) {
            System.out.println("Run #" + (i + 1));
            heapArrayInt(new ArrayList<>(ori));
            heapLinkedInt(new LinkedList<>(ori));
            System.out.println("-------------");
        }
        
    }
	
	private static void heapArrayInt(List<Integer> list) {
		long startTimeArrayList = System.nanoTime();
        HeapArray.sortIntegers(list); // Replace with your sorting method for ArrayList
        long endTimeArrayList = System.nanoTime();
        long durationArrayList = (endTimeArrayList - startTimeArrayList);
        System.out.println(list);
        System.out.println("ArrayList sorting time: " + durationArrayList + " ns");
	}
	
	private static void heapLinkedInt(LinkedList<Integer> list) {
		// Benchmark LinkedList
        long startTimeLinkedList = System.nanoTime();
        HeapLinked.sort(list); // Replace with your sorting method for LinkedList
        long endTimeLinkedList = System.nanoTime();
        long durationLinkedList = (endTimeLinkedList - startTimeLinkedList);
        System.out.println("LinkedList sorting time: " + durationLinkedList + " ns");
	}

}
