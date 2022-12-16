package heapsort;

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Ard arda aralarında virgül ile sayıları giriniz : ");
        String input = scanner.nextLine();
        String[] parts = input.split(",");
        int[] numbers = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            numbers[i] = Integer.parseInt(parts[i]);
        }

        
        boolean isMinHeap = isMinHeap(numbers, 3);
        System.out.println("Dizi 3-ary min heap mi?: " + isMinHeap);

        
        if (!isMinHeap) {
            buildMinHeap(numbers, 3);
        }

        
        System.out.println("Min heap: " + Arrays.toString(numbers));
    }

    
    public static boolean isMinHeap(int[] heap, int k) {
        for (int i = 0; i < heap.length; i++) {
            for (int j = 1; j <= k; j++) {
                int childIndex = k * i + j;
                if (childIndex < heap.length && heap[i] > heap[childIndex]) {
                    return false;
                }
            }
        }
        return true;
    }

    
    public static void buildMinHeap(int[] heap, int k) {
        for (int i = heap.length - 1; i >= 0; i--) {
            minHeapify(heap, i, heap.length, k);
        }
    }

    
    public static void minHeapify(int[] heap, int i, int heapSize, int k) {
        int minIndex = i;
        for (int j = 1; j <= k; j++) {
            int childIndex = k * i + j;
            if (childIndex < heapSize && heap[childIndex] < heap[minIndex]) {
                minIndex = childIndex;
            }
        }
        if (minIndex != i) {
            int temp = heap[i];
            heap[i] = heap[minIndex];
            heap[minIndex] = temp;
            minHeapify(heap, minIndex, heapSize, k);
        }
    }
}
