import java.util.*;


public class Buy_Sell_Stock_II {

	public static long getMaximumProfit (int n, long[] prices) {
		// Your code goes here.
		long[][] dp = new long[n + 1][2];

		for (int i = n - 1; i >= 0; i--) {
			for (int buy = 0; buy <= 1; buy++) {
				if (buy == 1) {
					dp[i][buy] = Math.max((-prices[i] + dp[i + 1][0]), (0 + dp[i + 1][1]));
				} else {
					dp[i][buy] = Math.max((prices[i] + dp[i + 1][1]), (0 + dp[i + 1][0]));
				}
			}
		}

		return dp[0][1];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] prices = new long[n];
		for (int i = 0; i < n; i++) {
			prices[i] = sc.nextLong();
		}
		System.out.println(getMaximumProfit(n, prices));
	}
}