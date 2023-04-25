import java.util.*;

public class PQheap<T> {
    private static final int MAX_SIZE = 15;
    Pair<Integer, T>[] heap;
    private int size;

    public PQheap() {
        heap = new Pair[MAX_SIZE];
        size = 0;
    }

    public static int parent(int i) {
        return (i - 1) / 2;
    }

    public static int leftChild(int i) {
        return 2 * i + 1;
    }

    public static int rightChild(int i) {
        return 2 * i + 2;
    }

    public static <T> void swap(Pair<Integer, T>[] heap, int i, int j) {
        Pair<Integer, T> temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public int getSize() {
        return size;
    }

    public int getMaxpriority() {
        return heap[0].getFirst();
    }

    public void InsertElement(int value, T data) {
        if (size >= MAX_SIZE) {
            System.out.println("The heap is full. Cannot insert");
            return;
        }

        heap[size] = new Pair<>(value, data);
        size++;

        int i = size - 1;
        while (i != 0 && heap[parent(i)].getFirst() < heap[i].getFirst()) {
            swap(heap, parent(i), i);
            i = parent(i);
        }
    }

    public void maxHeapify(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int largest = i;

        if (left <= size && heap[left].getFirst() > heap[largest].getFirst()) {
            largest = left;
        }

        if (right <= size && heap[right].getFirst() > heap[largest].getFirst()) {
            largest = right;
        }

        if (largest != i) {
            swap(heap, i, largest);
            maxHeapify(largest);
        }
    }

    public int GetMaxPriority() {
        return heap[0].getFirst();
    }

    public int pop() {
        int maxItem = heap[0].getFirst();
        System.out.println(heap[0].getFirst());
        System.out.println(heap[0].getSecond());
        heap[0] = heap[size - 1];
        size--;
        maxHeapify(0);
        return maxItem;
    }

    public void printQueue() {
        for (int i = 0; i < size; i++) {
            System.out.println(heap[i].getFirst());
            System.out.println(heap[i].getFirst());
        }
        System.out.println();
    }


}
