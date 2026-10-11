// Singly linked list
public class MyLinkedList {

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public void insertAtBeginning(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void insertAtEnd(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }

    public boolean insertAtPosition(int position, int value) {
        if (position < 0 || position > size) {
            System.out.println("Invalid position! Position must be between 0 and " + size);
            return false;
        }
        if (position == 0) {
            insertAtBeginning(value);
            return true;
        }
        Node temp = head;
        for (int i = 0; i < position - 1; i++) {
            temp = temp.next;
        }
        Node newNode = new Node(value);
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
        return true;
    }

    // deletes the first node with the given value
    public boolean delete(int value) {
        if (head == null) {
            return false;
        }
        if (head.data == value) {
            head = head.next;
            size--;
            return true;
        }
        Node prev = head;
        while (prev.next != null && prev.next.data != value) {
            prev = prev.next;
        }
        if (prev.next == null) {
            return false; // not found
        }
        prev.next = prev.next.next; // skip the node
        size--;
        return true;
    }

    // returns position of value or -1
    public int search(int value) {
        Node temp = head;
        int position = 0;
        while (temp != null) {
            if (temp.data == value) {
                return position;
            }
            temp = temp.next;
            position++;
        }
        return -1;
    }

    public void display() {
        if (head == null) {
            System.out.println("Linked list is empty.");
            return;
        }
        System.out.print("HEAD -> ");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL  (size " + size + ")");
    }

    public boolean isEmpty() { return head == null; }
    public int getSize() { return size; }
}
