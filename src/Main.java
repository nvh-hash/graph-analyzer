import java.util.Arrays;
import java.util.List;
import java.util.Random;

// Main class - menus and integration of all components
public class Main {
    static ArrayOperations array = new ArrayOperations(20);
    static MyStack stack = new MyStack(10);
    static MyQueue queue = new MyQueue(10);
    static MyLinkedList linkedList = new MyLinkedList();
    static Graph graph = new Graph();
    static PerformanceAnalyzer analyzer = new PerformanceAnalyzer();
    static int[] searchData = new int[0];

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=============================================");
            System.out.println("     DATA STRUCTURE & GRAPH ANALYZER");
            System.out.println("=============================================");
            System.out.println("1. Array Operations");
            System.out.println("2. Stack Operations");
            System.out.println("3. Queue Operations");
            System.out.println("4. Linked List Operations");
            System.out.println("5. Searching Operations");
            System.out.println("6. Graph Operations");
            System.out.println("7. Performance Comparison");
            System.out.println("8. Display All Results");
            System.out.println("9. Exit");
            choice = InputHelper.readIntInRange("Enter your choice: ", 1, 9);

            switch (choice) {
                case 1: arrayMenu(); break;
                case 2: stackMenu(); break;
                case 3: queueMenu(); break;
                case 4: linkedListMenu(); break;
                case 5: searchMenu(); break;
                case 6: graphMenu(); break;
                case 7:
                    analyzer.runSearchComparison();
                    analyzer.runGraphComparison(graph);
                    InputHelper.pause();
                    break;
                case 8: displayAll(); break;
                case 9: System.out.println("Exiting program. Goodbye!"); break;
            }
        } while (choice != 9);
    }

    // ---------------- ARRAY ----------------
    static void arrayMenu() {
        int choice;
        do {
            System.out.println("\n--------------- ARRAY OPERATIONS ------------");
            System.out.println("1. Insert (at end)");
            System.out.println("2. Insert at Index");
            System.out.println("3. Delete");
            System.out.println("4. Search");
            System.out.println("5. Display");
            System.out.println("6. Return to Main Menu");
            choice = InputHelper.readIntInRange("Enter your choice: ", 1, 6);

            switch (choice) {
                case 1:
                    int value = InputHelper.readInt("Enter value to insert: ");
                    if (array.insert(value)) System.out.println(value + " inserted.");
                    break;
                case 2:
                    int idx = InputHelper.readInt("Enter index (0 to " + array.getSize() + "): ");
                    int val = InputHelper.readInt("Enter value to insert: ");
                    if (array.insertAt(idx, val)) System.out.println(val + " inserted at index " + idx + ".");
                    break;
                case 3:
                    if (array.isEmpty()) {
                        System.out.println("Array is empty! Nothing to delete.");
                        break;
                    }
                    int del = InputHelper.readInt("Enter value to delete: ");
                    if (array.delete(del)) System.out.println(del + " deleted.");
                    else System.out.println(del + " not found in array.");
                    break;
                case 4:
                    if (array.isEmpty()) {
                        System.out.println("Array is empty! Nothing to search.");
                        break;
                    }
                    int key = InputHelper.readInt("Enter value to search: ");
                    int pos = array.search(key);
                    if (pos != -1) System.out.println(key + " found at index " + pos + ".");
                    else System.out.println(key + " not found.");
                    break;
                case 5:
                    array.display();
                    break;
            }
        } while (choice != 6);
    }

    // ---------------- STACK ----------------
    static void stackMenu() {
        int choice;
        do {
            System.out.println("\n--------------- STACK OPERATIONS ------------");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            choice = InputHelper.readIntInRange("Enter your choice: ", 1, 5);

            switch (choice) {
                case 1:
                    if (stack.isFull()) {
                        System.out.println("Stack Overflow! Stack is full.");
                        break;
                    }
                    int value = InputHelper.readInt("Enter value to push: ");
                    stack.push(value);
                    System.out.println(value + " pushed to stack.");
                    break;
                case 2:
                    if (stack.isEmpty()) System.out.println("Stack Underflow! Cannot pop from an empty stack.");
                    else System.out.println("Popped: " + stack.pop());
                    break;
                case 3:
                    if (stack.isEmpty()) System.out.println("Stack is empty! Nothing to peek.");
                    else System.out.println("Top element: " + stack.peek());
                    break;
                case 4:
                    stack.display();
                    break;
            }
        } while (choice != 5);
    }

    // ---------------- QUEUE ----------------
    static void queueMenu() {
        int choice;
        do {
            System.out.println("\n--------------- QUEUE OPERATIONS ------------");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek / Front");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            choice = InputHelper.readIntInRange("Enter your choice: ", 1, 5);

            switch (choice) {
                case 1:
                    if (queue.isFull()) {
                        System.out.println("Queue is full! Cannot enqueue.");
                        break;
                    }
                    int value = InputHelper.readInt("Enter value to enqueue: ");
                    queue.enqueue(value);
                    System.out.println(value + " added to queue.");
                    break;
                case 2:
                    if (queue.isEmpty()) System.out.println("Queue Underflow! Cannot dequeue from an empty queue.");
                    else System.out.println("Dequeued: " + queue.dequeue());
                    break;
                case 3:
                    if (queue.isEmpty()) System.out.println("Queue is empty! No front element.");
                    else System.out.println("Front element: " + queue.peek());
                    break;
                case 4:
                    queue.display();
                    break;
            }
        } while (choice != 5);
    }

    // ---------------- LINKED LIST ----------------
    static void linkedListMenu() {
        int choice;
        do {
            System.out.println("\n------------ LINKED LIST OPERATIONS ---------");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete");
            System.out.println("5. Search");
            System.out.println("6. Display");
            System.out.println("7. Return to Main Menu");
            choice = InputHelper.readIntInRange("Enter your choice: ", 1, 7);

            switch (choice) {
                case 1:
                    int v1 = InputHelper.readInt("Enter value: ");
                    linkedList.insertAtBeginning(v1);
                    System.out.println(v1 + " inserted at beginning.");
                    break;
                case 2:
                    int v2 = InputHelper.readInt("Enter value: ");
                    linkedList.insertAtEnd(v2);
                    System.out.println(v2 + " inserted at end.");
                    break;
                case 3:
                    int pos = InputHelper.readInt("Enter position (0 to " + linkedList.getSize() + "): ");
                    int v3 = InputHelper.readInt("Enter value: ");
                    if (linkedList.insertAtPosition(pos, v3)) System.out.println(v3 + " inserted at position " + pos + ".");
                    break;
                case 4:
                    if (linkedList.isEmpty()) {
                        System.out.println("Linked list is empty! Nothing to delete.");
                        break;
                    }
                    int del = InputHelper.readInt("Enter value to delete: ");
                    if (linkedList.delete(del)) System.out.println(del + " deleted.");
                    else System.out.println(del + " not found.");
                    break;
                case 5:
                    if (linkedList.isEmpty()) {
                        System.out.println("Linked list is empty! Nothing to search.");
                        break;
                    }
                    int key = InputHelper.readInt("Enter value to search: ");
                    int found = linkedList.search(key);
                    if (found != -1) System.out.println(key + " found at position " + found + ".");
                    else System.out.println(key + " not found.");
                    break;
                case 6:
                    linkedList.display();
                    break;
            }
        } while (choice != 7);
    }

    // ---------------- SEARCHING ----------------
    static void searchMenu() {
        int choice;
        do {
            System.out.println("\n-------------- SEARCHING OPERATIONS ---------");
            System.out.println("Current data size: " + searchData.length);
            System.out.println("1. Load Data from Array Module");
            System.out.println("2. Generate Random Data");
            System.out.println("3. Display Data");
            System.out.println("4. Linear Search");
            System.out.println("5. Binary Search");
            System.out.println("6. Compare Linear vs Binary");
            System.out.println("7. Return to Main Menu");
            choice = InputHelper.readIntInRange("Enter your choice: ", 1, 7);

            switch (choice) {
                case 1:
                    if (array.isEmpty()) {
                        System.out.println("Array module is empty! Add values in Array Operations first.");
                    } else {
                        searchData = array.toArray();
                        System.out.println(searchData.length + " values loaded from array.");
                    }
                    break;
                case 2:
                    int n = InputHelper.readIntInRange("Enter number of elements (1 - 1000000): ", 1, 1000000);
                    searchData = generateRandomData(n);
                    System.out.println(n + " random values generated (range 0 - " + (n * 10) + ").");
                    break;
                case 3:
                    displaySearchData();
                    break;
                case 4:
                case 5:
                case 6:
                    if (searchData.length == 0) {
                        System.out.println("No data! Load or generate data first.");
                        break;
                    }
                    int key = InputHelper.readInt("Enter value to search: ");
                    if (choice == 4) doLinear(key);
                    else if (choice == 5) doBinary(key);
                    else compareSearch(key);
                    break;
            }
        } while (choice != 7);
    }

    static int[] generateRandomData(int n) {
        Random rand = new Random();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = rand.nextInt(n * 10 + 1);
        }
        return data;
    }

    static void displaySearchData() {
        if (searchData.length == 0) {
            System.out.println("No data loaded.");
            return;
        }
        int limit = Math.min(searchData.length, 30);
        System.out.print("Data: ");
        for (int i = 0; i < limit; i++) {
            System.out.print(searchData[i] + " ");
        }
        if (searchData.length > limit) {
            System.out.print("... (" + (searchData.length - limit) + " more)");
        }
        System.out.println();
    }

    static SearchResult doLinear(int key) {
        SearchResult r = SearchAlgorithms.linearSearch(searchData, key);
        printSearchResult(r, key, "original data");
        return r;
    }

    static SearchResult doBinary(int key) {
        int[] sorted = searchData;
        if (!SearchAlgorithms.isSorted(searchData)) {
            sorted = Arrays.copyOf(searchData, searchData.length);
            Arrays.sort(sorted);
            System.out.println("(Data was not sorted, so a sorted copy is used for binary search)");
        }
        SearchResult r = SearchAlgorithms.binarySearch(sorted, key);
        printSearchResult(r, key, "sorted data");
        return r;
    }

    static void printSearchResult(SearchResult r, int key, String dataType) {
        System.out.println("\n[" + r.getAlgorithm() + "]");
        if (r.isFound()) System.out.println("Result : " + key + " found at index " + r.getIndex() + " of " + dataType);
        else System.out.println("Result : " + key + " not found");
        System.out.println("Steps  : " + r.getSteps());
        System.out.println("Time   : " + r.getTimeNs() + " ns");

        String result = r.isFound() ? "Found at " + r.getIndex() : "Not found";
        analyzer.addRecord(new PerformanceRecord("Search", r.getAlgorithm(),
                "n=" + searchData.length + ", key=" + key, result, r.getSteps(), r.getTimeNs()));
    }

    static void compareSearch(int key) {
        SearchResult linear = doLinear(key);
        SearchResult binary = doBinary(key);
        System.out.println("\n---------- COMPARISON ----------");
        System.out.printf("%-15s %-10s %-10s%n", "Algorithm", "Steps", "Time(ns)");
        System.out.printf("%-15s %-10d %-10d%n", "Linear Search", linear.getSteps(), linear.getTimeNs());
        System.out.printf("%-15s %-10d %-10d%n", "Binary Search", binary.getSteps(), binary.getTimeNs());
        System.out.println("Linear is O(n), Binary is O(log n) but needs sorted data.");
    }

    // ---------------- GRAPH ----------------
    static void graphMenu() {
        int choice;
        do {
            System.out.println("\n--------------- GRAPH OPERATIONS ------------");
            System.out.println("1. Add Vertex");
            System.out.println("2. Add Edge");
            System.out.println("3. Display Graph");
            System.out.println("4. BFS Traversal");
            System.out.println("5. DFS Traversal");
            System.out.println("6. Search Vertex (BFS vs DFS)");
            System.out.println("7. Load Sample Graph");
            System.out.println("8. Return to Main Menu");
            choice = InputHelper.readIntInRange("Enter your choice: ", 1, 8);

            switch (choice) {
                case 1:
                    String v = InputHelper.readText("Enter vertex name: ").toUpperCase();
                    if (graph.addVertex(v)) System.out.println("Vertex " + v + " added.");
                    break;
                case 2:
                    if (graph.getVertexCount() < 2) {
                        System.out.println("Need at least 2 vertices to add an edge.");
                        break;
                    }
                    String a = InputHelper.readText("Enter first vertex: ").toUpperCase();
                    String b = InputHelper.readText("Enter second vertex: ").toUpperCase();
                    if (graph.addEdge(a, b)) System.out.println("Edge " + a + " - " + b + " added.");
                    break;
                case 3:
                    graph.display();
                    break;
                case 4:
                case 5:
                    traverse(choice == 4);
                    break;
                case 6:
                    searchGraph();
                    break;
                case 7:
                    graph = Graph.createSampleGraph();
                    System.out.println("Sample graph loaded.");
                    graph.display();
                    break;
            }
        } while (choice != 8);
    }

    static String readExistingVertex(String message) {
        String v = InputHelper.readText(message).toUpperCase();
        if (!graph.hasVertex(v)) {
            System.out.println("Vertex " + v + " does not exist.");
            return null;
        }
        return v;
    }

    static void traverse(boolean isBfs) {
        if (graph.isEmpty()) {
            System.out.println("Graph is empty! Add vertices first.");
            return;
        }
        String start = readExistingVertex("Enter starting vertex: ");
        if (start == null) return;

        long t = System.nanoTime();
        List<String> order = isBfs ? graph.bfs(start) : graph.dfs(start);
        long time = System.nanoTime() - t;
        String name = isBfs ? "BFS" : "DFS";

        System.out.println(name + " Traversal: " + String.join(" -> ", order));
        System.out.println("Steps: " + graph.getSteps() + " | Time: " + time + " ns");
        if (order.size() < graph.getVertexCount()) {
            System.out.println("Note: some vertices are not reachable from " + start + ".");
        }
        analyzer.addRecord(new PerformanceRecord("Graph Traversal", name, "start=" + start,
                order.toString(), graph.getSteps(), time));
    }

    static void searchGraph() {
        if (graph.getVertexCount() < 2) {
            System.out.println("Need at least 2 vertices to search.");
            return;
        }
        String start = readExistingVertex("Enter starting vertex: ");
        if (start == null) return;
        String target = readExistingVertex("Enter vertex to find: ");
        if (target == null) return;

        long t = System.nanoTime();
        List<String> bfsOrder = graph.bfsSearch(start, target);
        long bfsTime = System.nanoTime() - t;
        int bfsSteps = graph.getSteps();

        t = System.nanoTime();
        List<String> dfsOrder = graph.dfsSearch(start, target);
        long dfsTime = System.nanoTime() - t;
        int dfsSteps = graph.getSteps();

        boolean found = bfsOrder.contains(target);
        System.out.println(found ? target + " is reachable from " + start : target + " is NOT reachable from " + start);
        System.out.println("BFS visited: " + String.join(" -> ", bfsOrder) + "  (steps " + bfsSteps + ")");
        System.out.println("DFS visited: " + String.join(" -> ", dfsOrder) + "  (steps " + dfsSteps + ")");

        String res = found ? "Found" : "Not reachable";
        analyzer.addRecord(new PerformanceRecord("Graph Search", "BFS", start + "->" + target, res, bfsSteps, bfsTime));
        analyzer.addRecord(new PerformanceRecord("Graph Search", "DFS", start + "->" + target, res, dfsSteps, dfsTime));
    }

    // ---------------- DISPLAY ALL ----------------
    static void displayAll() {
        System.out.println("\n=============================================");
        System.out.println("        CURRENT STATE OF ALL STRUCTURES");
        System.out.println("=============================================");
        System.out.println("\n[Array]");
        array.display();
        System.out.println("\n[Stack]");
        stack.display();
        System.out.println("\n[Queue]");
        queue.display();
        System.out.println("\n[Linked List]");
        linkedList.display();
        System.out.println("\n[Search Data]");
        displaySearchData();
        System.out.println("\n[Graph]");
        graph.display();

        analyzer.displayRecords();
        InputHelper.pause();
    }
}
