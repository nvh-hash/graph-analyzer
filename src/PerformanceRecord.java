// One row of performance data
public class PerformanceRecord {
    private String operation;
    private String algorithm;
    private String input;
    private String result;
    private int steps;
    private long timeNs;

    public PerformanceRecord(String operation, String algorithm, String input,
                             String result, int steps, long timeNs) {
        this.operation = operation;
        this.algorithm = algorithm;
        this.input = input;
        this.result = result;
        this.steps = steps;
        this.timeNs = timeNs;
    }

    public String getOperation() { return operation; }
    public String getAlgorithm() { return algorithm; }
    public String getInput() { return input; }
    public String getResult() { return result; }
    public int getSteps() { return steps; }
    public long getTimeNs() { return timeNs; }
}
