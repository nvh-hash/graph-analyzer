// Linear and binary search with step counting
public class SearchAlgorithms {

    // O(n) - checks every element one by one
    public static SearchResult linearSearch(int[] arr, int key) {
        int steps = 0;
        int index = -1;
        long start = System.nanoTime();

        for (int i = 0; i < arr.length; i++) {
            steps++;
            if (arr[i] == key) {
                index = i;
                break;
            }
        }

        long time = System.nanoTime() - start;
        return new SearchResult("Linear Search", index, steps, time);
    }

    // O(log n) - array must be sorted, halves the range each step
    public static SearchResult binarySearch(int[] arr, int key) {
        int steps = 0;
        int index = -1;
        int low = 0;
        int high = arr.length - 1;
        long start = System.nanoTime();

        while (low <= high) {
            steps++;
            int mid = low + (high - low) / 2; // avoids overflow
            if (arr[mid] == key) {
                index = mid;
                break;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        long time = System.nanoTime() - start;
        return new SearchResult("Binary Search", index, steps, time);
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) return false;
        }
        return true;
    }
}
