# Data Structure & Graph Performance Analyzer

CIT300 Data Structures and Algorithms - Graded Practical Assignment 2

## Project Description
A Java console application that lets the user work with different data structures
(Array, Stack, Queue, Linked List, Graph) and compare searching and graph traversal
algorithms. The program counts the number of steps and measures execution time so the
results can be related to algorithmic complexity.

## Team Members

| Member | Student Name | Student ID | Assigned Parts |
|---|---|---|---|
| Member 1 | R.K Nimna Nethsara | 22UG3-0006 | 1. Array Operations, 2. Stack Operations |
| Member 2 | P.D.N.N Rathnayaka | 22UG3-0846 | 3. Queue Operations, 4. Linked List Operations |
| Member 3 | R.A Hiruni Nimasha | 22UG3-0322 | 5. Searching Operations, 6. Graph Operations |
| Member 4 | K.A. Kaushalya Gayathri | 22UG3-0302 | 7. Performance Comparison, 8. Display All Results, 9. Exit |

## Individual Contributions

**Student Name:** R.K Nimna Nethsara  
**Student ID:** 22UG3-0006  
**Assigned Responsibility:** Array Operations and Stack Operations  
**Individual Contribution:**
- Implemented array operations (insert, insert at index, delete, search, display)
- Implemented stack operations (push, pop, peek, display)
- Tested array and stack functionality

**Student Name:** P.D.N.N Rathnayaka  
**Student ID:** 22UG3-0846  
**Assigned Responsibility:** Queue Operations and Linked List Operations  
**Individual Contribution:**
- Implemented queue operations using a circular array (enqueue, dequeue, peek, display)
- Implemented linked-list operations (insert, delete, search, display)
- Tested queue and linked-list functionality

**Student Name:** R.A Hiruni Nimasha  
**Student ID:** 22UG3-0322  
**Assigned Responsibility:** Searching Operations and Graph Operations  
**Individual Contribution:**
- Implemented linear search and binary search with step counting
- Implemented graph operations using an adjacency list
- Implemented BFS and DFS traversal and vertex search
- Tested searching and graph functionality

**Student Name:** K.A. Kaushalya Gayathri  
**Student ID:** 22UG3-0302  
**Assigned Responsibility:** Performance Comparison, Display All Results, and Exit  
**Individual Contribution:**
- Implemented performance comparison features for searching and graph traversal algorithms
- Implemented the display-all-results feature
- Contributed to integration and testing of the complete system

## Technologies Used
- Java (JDK 17)
- Git and GitHub
- IntelliJ IDEA / VS Code

## Main System Features
1. **Array Operations** - insert, insert at index, delete, search, display (capacity 20)
2. **Stack Operations** - push, pop, peek, display (capacity 10, handles overflow/underflow)
3. **Queue Operations** - enqueue, dequeue, peek, display (circular queue, capacity 10)
4. **Linked List Operations** - insert at beginning/end/position, delete, search, display
5. **Searching Operations** - linear and binary search on array data or random data, with steps and time
6. **Graph Operations** - add vertex, add edge, display, BFS, DFS, search vertex, sample graph
7. **Performance Comparison** - linear vs binary search for different input sizes, BFS vs DFS
8. **Display All Results** - shows the state of all structures and every recorded result
9. **Exit** - exits the application safely

## Project Structure
```text
src/
 ├── Main.java                 # menus and integration
 ├── InputHelper.java          # input validation
 ├── ArrayOperations.java
 ├── MyStack.java
 ├── MyQueue.java
 ├── MyLinkedList.java
 ├── SearchAlgorithms.java
 ├── SearchResult.java
 ├── Graph.java
 ├── PerformanceAnalyzer.java
 └── PerformanceRecord.java
```

## How to Run
Make sure JDK 8 or higher is installed.

```bash
cd src
javac *.java
java Main
```

Or open the project in IntelliJ IDEA and run `Main.java`.

## Complexity Summary

| Structure / Algorithm | Operation | Time Complexity |
|---|---|---|
| Array | Insert at end | O(1) |
| Array | Insert at index / Delete / Search | O(n) |
| Stack | Push / Pop / Peek | O(1) |
| Queue | Enqueue / Dequeue / Peek | O(1) |
| Linked List | Insert at beginning | O(1) |
| Linked List | Insert at end / Delete / Search | O(n) |
| Linear Search | Search | O(n) |
| Binary Search | Search (sorted data) | O(log n) |
| BFS / DFS | Traversal | O(V + E) |
