package ifmo.misc;

public class Answer<T> {
    private T solution;
    private int partitionAmount;
    private T error;

    public T getSolution() {
        return solution;
    }

    public void setSolution(T solution) {
        this.solution = solution;
    }

    public int getPartitionAmount() {
        return partitionAmount;
    }

    public void setPartitionAmount(int partitionAmount) {
        this.partitionAmount = partitionAmount;
    }

    public T getError() {
        return error;
    }

    public void setError(T error) {
        this.error = error;
    }
}
