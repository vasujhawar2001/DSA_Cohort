import java.util.Arrays;

public class Main {

    public static void main(String[] arg)
    {
        // Display message for better readability
        System.out.println("The Max Heap is ");

        MaxHeap maxHeap = new MaxHeap(15);

        // Inserting nodes
        // Custom inputs
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);

        // Calling maxHeap() as defined above
        System.out.println(Arrays.toString(maxHeap.Heap));

        // Print and display the maximum value in heap
        System.out.println("The max val is "
                + maxHeap.extractMax());

        maxHeap.insert(100);
        System.out.println(Arrays.toString(maxHeap.Heap));
        maxHeap.insert(24);
        System.out.println(Arrays.toString(maxHeap.Heap));

    }

}
