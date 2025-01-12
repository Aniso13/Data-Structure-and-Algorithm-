package Heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    private List<Integer> heap;

    public Heap() {
        this.heap = new ArrayList<>();
    }

    // Get a copy of the heap
    public List<Integer> getHeap() {
        return new ArrayList<>(heap);
    }

    // Calculate left child index
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    // Calculate right child index
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    // Calculate parent index
    private int parent(int index) {
        return (index - 1) / 2;
    }

    // Swap two elements in the heap
    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    // Insert a value into the heap
    public void insert(int value) {
        heap.add(value); // Add the value to the end
        int current = heap.size() - 1;

        // Bubble up to maintain the max-heap property
        while (current > 0 && heap.get(current) > heap.get(parent(current))) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int extractMax() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        int max = heap.get(0); // Root value
        int lastValue = heap.remove(heap.size() - 1); // Remove the last element

        if (!heap.isEmpty()) {
            heap.set(0, lastValue); // Move last element to root
            heapifyDown(0); // Restore the heap property
        }

        return max;
    }

    // Restore the heap property by bubbling down
    private void heapifyDown(int index) {
        int largest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        // Check if left child is larger
        if (left < heap.size() && heap.get(left) > heap.get(largest)) {
            largest = left;
        }

        // Check if right child is larger
        if (right < heap.size() && heap.get(right) > heap.get(largest)) {
            largest = right;
        }

        // If the largest is not the current index, swap and continue
        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }
    private void sinkDown(int index) {
        int maxIndex = index;
        while (true) {
            int leftIndex = leftChild(index);
            int rightIndex = rightChild(index);

            if (leftIndex < heap.size() && heap.get(leftIndex) > heap.get(maxIndex)) {
                maxIndex = leftIndex;
            }

            if (rightIndex < heap.size() && heap.get(rightIndex) > heap.get(maxIndex)) {
                maxIndex = rightIndex;
            }

            if (maxIndex != index) {
                swap(index, maxIndex);
                index = maxIndex;
            } else {
                return;
            }
        }
    }

    public Integer remove() {
        if (heap.size() == 0) {
            return null;
        }

        if (heap.size() == 1) {
            return heap.remove(0);
        }

        int maxValue = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        sinkDown(0);

        return maxValue;
    }
}


