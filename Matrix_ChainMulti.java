import java.util.*;

public class Matrix_ChainMulti {

	public static int matrixMultiplication(int[] arr , int n) {
		// Write your code here
		int[][] dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			dp[i][i] = 0;
		}

		for (int i = n - 1; i >= 1; i--) {
			for (int j = i + 1; j < n; j++) {
				int min_steps = Integer.MAX_VALUE;
				for (int k = i; k <= j - 1; k++) {
					int steps = (arr[i - 1] * arr[k] * arr[j]) + dp[i][k] + dp[k + 1][j];
					min_steps = Math.min(steps, min_steps);
				}
				dp[i][j] = min_steps;
			}
		}

		return dp[1][n - 1];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(matrixMultiplication(arr, n));
	}
}