// Fixed size array with insert, delete, search and display
public class ArrayOperations {
    private int[] arr;
    private int size;

    public ArrayOperations(int capacity) {
        arr = new int[capacity];
        size = 0;
    }

    public boolean insert(int value) {
        if (isFull()) {
            System.out.println("Array is full! Cannot insert.");
            return false;
        }
        arr[size] = value;
        size++;
        return true;
    }

    public boolean insertAt(int index, int value) {
        if (isFull()) {
            System.out.println("Array is full! Cannot insert.");
            return false;
        }
        if (index < 0 || index > size) {
            System.out.println("Invalid index! Index must be between 0 and " + size);
            return false;
        }
        // shift elements to the right to make space
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = value;
        size++;
        return true;
    }

    public boolean delete(int value) {
        int index = search(value);
        if (index == -1) {
            return false;
        }
        // shift elements to the left to fill the gap
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        return true;
    }

    // linear search, returns index or -1
    public int search(int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Array is empty.");
            return;
        }
        System.out.print("Array: [");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]);
            if (i < size - 1) System.out.print(", ");
        }
        System.out.println("]  (size " + size + "/" + arr.length + ")");
    }

    // returns a copy of the used part of the array
    public int[] toArray() {
        int[] copy = new int[size];
        for (int i = 0; i < size; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

    public boolean isEmpty() { return size == 0; }
    public boolean isFull() { return size == arr.length; }
    public int getSize() { return size; }
}
