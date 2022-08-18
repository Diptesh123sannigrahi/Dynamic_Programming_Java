import java.util.*;


public class Buy_Sell_Stock_WithCooldown {

	public static int stockProfit(int[] prices) {
		// Write your code here.
		int n = prices.length;
		int[][] dp = new int[n + 2][2];

		for (int i = n - 1; i >= 0; i--) {
			for (int buy = 0; buy <= 1; buy++) {
				if (buy == 1) {
					dp[i][buy] = Math.max((-prices[i] + dp[i + 1][0]), (0 + dp[i + 1][1]));
				} else {
					dp[i][buy] = Math.max((prices[i] + dp[i + 2][1]), (0 + dp[i + 1][0]));
				}
			}
		}

		return dp[0][1];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] prices = new int[n];
		for (int i = 0; i < n; i++) {
			prices[i] = sc.nextInt();
		}
		System.out.println(stockProfit(prices));
	}
}