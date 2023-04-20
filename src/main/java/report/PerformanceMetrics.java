package report;

public class PerformanceMetrics {
    
    /**
     * Measures the execution time of a given code block in milliseconds.
     * 
     * @param codeBlock the code block to measure the execution time of
     * @return the execution time of the code block in milliseconds
     */
    public static long measureExecutionTime(Runnable codeBlock) {
        long startTime = System.nanoTime();
        codeBlock.run();
        long endTime = System.nanoTime();
        long elapsedTimeInNanos = endTime - startTime;
        return elapsedTimeInNanos / 1_000_000;
    }
}
