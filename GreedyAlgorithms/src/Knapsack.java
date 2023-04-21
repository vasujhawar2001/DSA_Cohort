import java.util.Arrays;

public class Knapsack {

    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] items = new int[n][2];

        for (int i = 0; i < n; i++) {
            items[i][0] = weights[i];
            items[i][1] = values[i];
        }

        Arrays.sort(items, (a, b) -> Double.compare(b[1] * 1.0 / b[0], a[1] * 1.0 / a[0]));

        int result = 0;
        int remainingCapacity = capacity;

        for (int i = 0; i < n; i++) {
            int weight = items[i][0];
            int value = items[i][1];

            if (weight <= remainingCapacity) {
                result += value;
                remainingCapacity -= weight;
            } else {
                result += value * (remainingCapacity * 1.0 / weight);
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        int capacity = 50;

        int maxProfit = knapsack(weights, values, capacity);
        System.out.println("Maximum profit: " + maxProfit);
    }
}
