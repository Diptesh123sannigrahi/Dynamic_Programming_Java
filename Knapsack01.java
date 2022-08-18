import java.util.*;

public class Knapsack01 {

	public static int result(ArrayList<Integer> values, ArrayList<Integer> weights, int w, int i, int[][] dp) {
		if (i == 0) {
			if (weights.get(0) <= w) {
				return values.get(0);
			} else {
				return 0;
			}
		}

		if (dp[i][w] != -1) {
			return dp[i][w];
		}

		int not_taken = 0 + result(values, weights, w, i - 1, dp);
		int taken = 0;
		if (weights.get(i) <= w) {
			taken = values.get(i) + result(values, weights, w - weights.get(i), i - 1, dp);
		}

		return dp[i][w] = Math.max(not_taken, taken);

	}

	public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
		// Write your code here.
		int[][] dp = new int[n][w + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < w + 1; j++) {
				dp[i][j] = -1;
			}
		}
		int res = result(values, weights, w, n - 1, dp);
		return res;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int w = sc.nextInt();
		ArrayList<Integer> weights = new ArrayList<>();
		ArrayList<Integer> values = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			weights.add(sc.nextInt());
		}
		for (int i = 0; i < n; i++) {
			values.add(sc.nextInt());
		}
		System.out.println("Maximum Profit is: " + maxProfit(values, weights, n, w));

	}
}