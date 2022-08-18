import java.util.*;

public class Rod_Cutting {

	public static int result(int i, int n, int[] price, int[][] dp) {
		if (i == price.length) {
			return 0;
		}
		if (i == n) {
			return 0;
		}

		if (n == 0) {
			return 0;
		}

		if (dp[i][n] != -1) {
			return dp[i][n];
		}

		int cut = 0;
		int rep_cut = 0;
		if (i <= n) {
			cut = price[i] + result(i + 1, n - i - 1, price, dp);
			rep_cut = price[i] + result(i, n - i - 1, price, dp);
		}

		int not_cut = result(i + 1, n, price, dp);

		return dp[i][n] = Math.max(cut, Math.max(rep_cut, not_cut));

	}

	public static int cutRod(int price[], int n) {
		// Write your code here.
		int[][] dp = new int[n][n + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= n; j++) {
				dp[i][j] = -1;
			}
		}
		return result(0, n, price, dp);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] price = new int[n];
		for (int i = 0; i < n; i++) {
			price[i] = sc.nextInt();
		}
		System.out.println(cutRod(price, n));
	}
}