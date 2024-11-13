import java.util.Arrays;

public class Quicksort {

    // Main function to run quicksort
    public static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            // pi is partitioning index, arr[pi] is now in the correct place
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after partition
            quicksort(arr, low, pi - 1);
            quicksort(arr, pi + 1, high);
        }
    }

    // Partition function to place pivot element at its correct position
    private static int partition(int[] arr, int low, int high) {
        // Choose the rightmost element as pivot
        int pivot = arr[high];
        int i = (low - 1);  // Index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;  // Increment index of smaller element
                // Swap arr[i] and arr[j]
                swap(arr, i, j);
            }
        }

        // Swap arr[i + 1] and arr[high] (or pivot)
        swap(arr, i + 1, high);

        return i + 1;  // Return partitioning index
    }

    // Swap utility method
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Main method to test the quicksort algorithm
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        System.out.println("Original array: " + Arrays.toString(arr));

        quicksort(arr, 0, arr.length - 1);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
