// Array based stack (LIFO)
public class MyStack {
    private int[] items;
    private int top;

    public MyStack(int capacity) {
        items = new int[capacity];
        top = -1;
    }

    public boolean push(int value) {
        if (isFull()) {
            return false; // stack overflow
        }
        top++;
        items[top] = value;
        return true;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack Underflow");
        }
        int value = items[top];
        top--;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return items[top];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Stack (top to bottom):");
        for (int i = top; i >= 0; i--) {
            if (i == top) {
                System.out.println("  | " + items[i] + " |  <- TOP");
            } else {
                System.out.println("  | " + items[i] + " |");
            }
        }
        System.out.println("  -----");
    }

    public boolean isEmpty() { return top == -1; }
    public boolean isFull() { return top == items.length - 1; }
    public int getSize() { return top + 1; }
}
