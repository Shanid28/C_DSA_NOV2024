import java.util.Arrays;

public class MergeSort {

    // Method to perform merge sort
    public static void mergeSort(int[] array) {
        if (array.length < 2) {
            return; // Base case: array is already sorted (1 or 0 elements)
        }

        int mid = array.length / 2;

        // Divide the array into two halves
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        // Recursively sort both halves
        mergeSort(left);
        mergeSort(right);

        // Merge the sorted halves back into the original array
        merge(array, left, right);
    }

    // Method to merge two sorted arrays into one sorted array
    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Merge the left and right arrays
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // If there are remaining elements in the left array, add them
        while (i < left.length) {
            array[k++] = left[i++];
        }

        // If there are remaining elements in the right array, add them
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    // Main method to test merge sort
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Original array: " + Arrays.toString(array));

        mergeSort(array);

        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
