import java.util.*;

// Undirected graph using an adjacency list
public class Graph {
    private Map<String, List<String>> adjList;
    private int edgeCount;
    private int steps; // steps of the last traversal/search

    public Graph() {
        adjList = new LinkedHashMap<>(); // keeps insertion order
        edgeCount = 0;
    }

    public boolean addVertex(String vertex) {
        if (adjList.containsKey(vertex)) {
            System.out.println("Vertex '" + vertex + "' already exists.");
            return false;
        }
        adjList.put(vertex, new ArrayList<>());
        return true;
    }

    public boolean addEdge(String v1, String v2) {
        if (!adjList.containsKey(v1) || !adjList.containsKey(v2)) {
            System.out.println("Both vertices must exist before adding an edge.");
            return false;
        }
        if (v1.equals(v2)) {
            System.out.println("Self loops are not allowed.");
            return false;
        }
        if (adjList.get(v1).contains(v2)) {
            System.out.println("Edge already exists.");
            return false;
        }
        // undirected, so add both ways
        adjList.get(v1).add(v2);
        adjList.get(v2).add(v1);
        edgeCount++;
        return true;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Graph is empty.");
            return;
        }
        System.out.println("Adjacency List (" + getVertexCount() + " vertices, " + edgeCount + " edges):");
        for (String vertex : adjList.keySet()) {
            System.out.println("  " + vertex + " -> " + adjList.get(vertex));
        }
    }

    // Breadth First Search - uses a queue, visits level by level
    public List<String> bfs(String start) {
        List<String> order = new ArrayList<>();
        steps = 0;
        if (!hasVertex(start)) return order;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            order.add(current);
            steps++;
            for (String neighbour : adjList.get(current)) {
                steps++;
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
        return order;
    }

    // Depth First Search - recursive, goes as deep as possible first
    public List<String> dfs(String start) {
        List<String> order = new ArrayList<>();
        steps = 0;
        if (!hasVertex(start)) return order;

        dfsHelper(start, new HashSet<>(), order);
        return order;
    }

    private void dfsHelper(String current, Set<String> visited, List<String> order) {
        visited.add(current);
        order.add(current);
        steps++;
        for (String neighbour : adjList.get(current)) {
            steps++;
            if (!visited.contains(neighbour)) {
                dfsHelper(neighbour, visited, order);
            }
        }
    }

    // BFS that stops when target is found, returns visited order
    public List<String> bfsSearch(String start, String target) {
        List<String> order = new ArrayList<>();
        steps = 0;
        if (!hasVertex(start) || !hasVertex(target)) return order;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            order.add(current);
            steps++;
            if (current.equals(target)) {
                return order;
            }
            for (String neighbour : adjList.get(current)) {
                steps++;
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
        return order; // target not reachable
    }

    // DFS that stops when target is found
    public List<String> dfsSearch(String start, String target) {
        List<String> order = new ArrayList<>();
        steps = 0;
        if (!hasVertex(start) || !hasVertex(target)) return order;

        dfsSearchHelper(start, target, new HashSet<>(), order);
        return order;
    }

    private boolean dfsSearchHelper(String current, String target, Set<String> visited, List<String> order) {
        visited.add(current);
        order.add(current);
        steps++;
        if (current.equals(target)) {
            return true;
        }
        for (String neighbour : adjList.get(current)) {
            steps++;
            if (!visited.contains(neighbour)) {
                if (dfsSearchHelper(neighbour, target, visited, order)) {
                    return true;
                }
            }
        }
        return false;
    }

    // ready made graph for testing and demo
    public static Graph createSampleGraph() {
        Graph g = new Graph();
        String[] vertices = {"A", "B", "C", "D", "E", "F", "G"};
        for (String v : vertices) {
            g.addVertex(v);
        }
        g.addEdge("A", "B");
        g.addEdge("A", "C");
        g.addEdge("B", "D");
        g.addEdge("B", "E");
        g.addEdge("C", "F");
        g.addEdge("E", "G");
        g.addEdge("F", "G");
        return g;
    }

    public boolean hasVertex(String vertex) { return adjList.containsKey(vertex); }
    public boolean isEmpty() { return adjList.isEmpty(); }
    public int getVertexCount() { return adjList.size(); }
    public int getEdgeCount() { return edgeCount; }
    public int getSteps() { return steps; }
    public List<String> getVertices() { return new ArrayList<>(adjList.keySet()); }
}
