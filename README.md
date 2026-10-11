# Data Structure & Graph Performance Analyzer

CIT300 Data Structures and Algorithms - Graded Practical Assignment 2

## Project Description
A Java console application that lets the user work with different data structures
(Array, Stack, Queue, Linked List, Graph) and compare searching and graph traversal
algorithms. The program counts the number of steps and measures execution time so the
results can be related to algorithmic complexity.

## Team Members

| Student Name | Student ID | Assigned Responsibility |
|---|---|---|
| [Name 1] | [ID] | Array and Searching |
| [Name 2] | [ID] | Stack and Queue |
| [Name 3] | [ID] | Linked List |
| [Name 4] | [ID] | Graph and Traversal |
| [Name 5] | [ID] | Performance Comparison, Main Menu, Integration and Testing |

## Individual Contributions

**Student Name:** [Name 1]
**Student ID:** [ID]
**Assigned Responsibility:** Array and Searching
**Individual Contribution:**
- Implemented `ArrayOperations` class (insert, insert at index, delete, search, display)
- Implemented `SearchAlgorithms` class (linear search and binary search with step counting)
- Implemented `SearchResult` class
- Tested array and search functionality

**Student Name:** [Name 2]
**Student ID:** [ID]
**Assigned Responsibility:** Stack and Queue
**Individual Contribution:**
- Implemented `MyStack` class (push, pop, peek, display)
- Implemented `MyQueue` class using a circular array (enqueue, dequeue, peek, display)
- Handled stack overflow/underflow and empty/full queue conditions
- Tested stack and queue functionality

**Student Name:** [Name 3]
**Student ID:** [ID]
**Assigned Responsibility:** Linked List
**Individual Contribution:**
- Implemented `MyLinkedList` class with inner `Node` class
- Implemented insert at beginning, end and position
- Implemented delete, search and display
- Tested linked list functionality

**Student Name:** [Name 4]
**Student ID:** [ID]
**Assigned Responsibility:** Graph Component
**Individual Contribution:**
- Implemented `Graph` class using an adjacency list
- Implemented add vertex and add edge operations
- Implemented BFS and DFS traversal
- Implemented BFS/DFS vertex search and sample graph
- Tested graph functionality

**Student Name:** [Name 5]
**Student ID:** [ID]
**Assigned Responsibility:** Performance Comparison, Main Menu, Integration
**Individual Contribution:**
- Implemented `Main` class with main menu and all submenus
- Implemented `InputHelper` class for input validation
- Implemented `PerformanceAnalyzer` and `PerformanceRecord` classes
- Integrated all modules and tested the complete system

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
9. Input validation for all menus and inputs

## Project Structure
```
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
