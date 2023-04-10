import java.util.*;

// Chained HASHING
public class HashTable {
    private LinkedList<Integer>[] table;
    private int size;

    // Constructor to initialize the Hash Table with given size
    public HashTable(int size) {
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<Integer>();
        }
        this.size = size;
    }

    private int hashFunc(int value){   //1111111%10001 -> index range  0 -10^4
        return value%size;
    }

    // Method to insert a key-value pair into the Hash Table
    public void insert(int key, int value) {
        int hash = hashFunc(key);
        table[hash].add(value);
    }

    // Method to delete a key-value pair from the Hash Table
    public void delete(int key, int value) {
        int hash = hashFunc(key);
        table[hash].remove((Integer) value);
    }

    // Method to search for a key-value pair in the Hash Table
    public boolean search(int key, int value) {
        int hash = hashFunc(key);
        return table[hash].contains(value);
    }

    // Method to display the contents of the Hash Table
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print("Bucket " + i + ": ");
            for (Integer value : table[i]) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(5);
        hashTable.insert(0, 5);
        hashTable.insert(1, 10);
        hashTable.insert(2, 15);
        hashTable.insert(3, 20);
        hashTable.insert(4, 25);

        System.out.println("Hash Table:");
        hashTable.display();

        System.out.println("\nDeleting 15 from the Hash Table...");
        hashTable.delete(2, 15);

        System.out.println("Hash Table:");
        hashTable.display();

        System.out.println("\nSearching for 25 in the Hash Table...");
        if (hashTable.search(4, 25)) {
            System.out.println("Found!");
        } else {
            System.out.println("Not Found!");
        }
    }
}
