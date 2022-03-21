package edowl.Model;

import java.util.List;

public class Statistic {
    private String Task;
    private double avgScore;
    private double origValue;
    private double avgTime;
    public int amount;

    public Statistic() { }

    public Statistic(String task, double avgScore, double avgTime, int amount, double origValue) {
        Task = task;
        this.avgScore = avgScore;
        this.avgTime = avgTime;
        this.amount = amount;
        this.origValue = origValue;
    }

    public Double generateAvg(List<Double> values){
        Double sum = 0.0;
        if(!values.isEmpty()) {
            for (Double value : values) {
                sum += value;
            }
            return sum / values.size();
        }
        return sum;
//        return values.stream().mapToDouble((a) -> a).summaryStatistics();
    }

    public String getTask() {
        return Task;
    }

    public void setTask(String task) {
        Task = task;
    }

    public double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }

    public double getOrigValue() {
        return origValue;
    }

    public void setOrigValue(double origValue) {
        this.origValue = origValue;
    }

    public double getAvgTime() {
        return avgTime;
    }

    public void setAvgTime(double avgTime) {
        this.avgTime = avgTime;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
