import java.util.*;


public class Buy_Sell_Stock_IV {

	public static int maximumProfit(int[] prices, int n, int k) {
		// Write your code here.
		int[][][] dp = new int[n + 1][2][k + 1];

		for (int i = n - 1; i >= 0; i--) {
			for (int buy = 0; buy <= 1; buy++) {
				for (int cap = 1; cap <= k; cap++) {
					if (buy == 1) {
						dp[i][buy][cap] = Math.max((-prices[i] + dp[i + 1][0][cap]), (0 + dp[i + 1][1][cap]));
					} else {
						dp[i][buy][cap] = Math.max((prices[i] + dp[i + 1][1][cap - 1]), (0 + dp[i + 1][0][cap]));
					}
				}
			}
		}

		return dp[0][1][k];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] prices = new int[n];
		for (int i = 0; i < n; i++) {
			prices[i] = sc.nextInt();
		}
		System.out.println(maximumProfit(prices, n, k));
	}
}