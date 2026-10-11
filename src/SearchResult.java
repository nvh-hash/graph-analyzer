// Stores the outcome of a search
public class SearchResult {
    private String algorithm;
    private int index;
    private int steps;
    private long timeNs;

    public SearchResult(String algorithm, int index, int steps, long timeNs) {
        this.algorithm = algorithm;
        this.index = index;
        this.steps = steps;
        this.timeNs = timeNs;
    }

    public String getAlgorithm() { return algorithm; }
    public int getIndex() { return index; }
    public int getSteps() { return steps; }
    public long getTimeNs() { return timeNs; }
    public boolean isFound() { return index != -1; }
}
