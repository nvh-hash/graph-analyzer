// Circular array based queue (FIFO)
public class MyQueue {
    private int[] items;
    private int front;
    private int rear;
    private int count;

    public MyQueue(int capacity) {
        items = new int[capacity];
        front = 0;
        rear = -1;
        count = 0;
    }

    public boolean enqueue(int value) {
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % items.length; // wrap around
        items[rear] = value;
        count++;
        return true;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue Underflow");
        }
        int value = items[front];
        front = (front + 1) % items.length;
        count--;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return items[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("FRONT -> ");
        for (int i = 0; i < count; i++) {
            System.out.print(items[(front + i) % items.length] + " ");
        }
        System.out.println("<- REAR");
    }

    public boolean isEmpty() { return count == 0; }
    public boolean isFull() { return count == items.length; }
    public int getSize() { return count; }
}
