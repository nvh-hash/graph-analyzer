import java.util.ArrayList;
import java.util.List;

// Runs comparisons and keeps a history of all results
public class PerformanceAnalyzer {
    private ArrayList<PerformanceRecord> records;

    public PerformanceAnalyzer() {
        records = new ArrayList<>();
    }

    public void addRecord(PerformanceRecord record) {
        records.add(record);
    }

    public void runSearchComparison() {
        int[] sizes = {10, 100, 1000, 10000, 100000, 1000000};

        System.out.println("\n=============================================================");
        System.out.println("        LINEAR vs BINARY SEARCH (worst case)");
        System.out.println("=============================================================");
        System.out.println("Searching for a value that is NOT in the array (-1)");
        System.out.printf("%-10s %-14s %-14s %-12s %-12s%n",
                "Size(n)", "Linear Steps", "Binary Steps", "Linear(ns)", "Binary(ns)");
        System.out.println("-------------------------------------------------------------");

        for (int n : sizes) {
            int[] data = new int[n];
            for (int i = 0; i < n; i++) {
                data[i] = i * 2; // already sorted
            }
            int key = -1;

            SearchResult linear = SearchAlgorithms.linearSearch(data, key);
            SearchResult binary = SearchAlgorithms.binarySearch(data, key);

            System.out.printf("%-10d %-14d %-14d %-12d %-12d%n",
                    n, linear.getSteps(), binary.getSteps(), linear.getTimeNs(), binary.getTimeNs());

            addRecord(new PerformanceRecord("Search", "Linear Search", "n=" + n + ", key=-1",
                    "Not found", linear.getSteps(), linear.getTimeNs()));
            addRecord(new PerformanceRecord("Search", "Binary Search", "n=" + n + ", key=-1",
                    "Not found", binary.getSteps(), binary.getTimeNs()));
        }
        System.out.println("-------------------------------------------------------------");
        System.out.println("Linear search grows with n -> O(n)");
        System.out.println("Binary search grows with log2(n) -> O(log n)");
    }

    public void runGraphComparison(Graph graph) {
        if (graph.isEmpty() || graph.getVertexCount() < 2) {
            System.out.println("\nYour graph has less than 2 vertices, so the sample graph is used.");
            graph = Graph.createSampleGraph();
        }
        List<String> vertices = graph.getVertices();
        String start = vertices.get(0);
        String target = vertices.get(vertices.size() - 1);

        System.out.println("\n=============================================================");
        System.out.println("              BFS vs DFS GRAPH TRAVERSAL");
        System.out.println("=============================================================");
        System.out.println("Vertices = " + graph.getVertexCount() + ", Edges = " + graph.getEdgeCount()
                + ", Start = " + start + ", Target = " + target);
        System.out.printf("%-22s %-6s %-8s %-10s %s%n", "Operation", "Algo", "Steps", "Time(ns)", "Order");
        System.out.println("-------------------------------------------------------------");

        long t = System.nanoTime();
        List<String> bfsOrder = graph.bfs(start);
        printGraphRow("Full Traversal", "BFS", graph.getSteps(), System.nanoTime() - t, bfsOrder);

        t = System.nanoTime();
        List<String> dfsOrder = graph.dfs(start);
        printGraphRow("Full Traversal", "DFS", graph.getSteps(), System.nanoTime() - t, dfsOrder);

        t = System.nanoTime();
        List<String> bfsFind = graph.bfsSearch(start, target);
        printGraphRow("Search for " + target, "BFS", graph.getSteps(), System.nanoTime() - t, bfsFind);

        t = System.nanoTime();
        List<String> dfsFind = graph.dfsSearch(start, target);
        printGraphRow("Search for " + target, "DFS", graph.getSteps(), System.nanoTime() - t, dfsFind);

        System.out.println("-------------------------------------------------------------");
        System.out.println("Full traversal: both visit every vertex and edge -> O(V + E)");
        System.out.println("Search: steps depend on where the target is located");
    }

    private void printGraphRow(String operation, String algo, int steps, long time, List<String> order) {
        System.out.printf("%-22s %-6s %-8d %-10d %s%n", operation, algo, steps, time, order);
        addRecord(new PerformanceRecord("Graph " + operation, algo, "", order.toString(), steps, time));
    }

    public void displayRecords() {
        System.out.println("\n=========================================================================");
        System.out.println("                      ALL RECORDED RESULTS");
        System.out.println("=========================================================================");
        if (records.isEmpty()) {
            System.out.println("No results recorded yet. Try searching, traversing or option 7.");
            return;
        }
        System.out.printf("%-4s %-22s %-14s %-8s %-10s %s%n",
                "No", "Operation", "Algorithm", "Steps", "Time(ns)", "Details");
        System.out.println("-------------------------------------------------------------------------");
        for (int i = 0; i < records.size(); i++) {
            PerformanceRecord r = records.get(i);
            String details = r.getInput().isEmpty() ? r.getResult() : r.getInput() + " | " + r.getResult();
            System.out.printf("%-4d %-22s %-14s %-8d %-10d %s%n",
                    (i + 1), r.getOperation(), r.getAlgorithm(), r.getSteps(), r.getTimeNs(), details);
        }
    }
}
