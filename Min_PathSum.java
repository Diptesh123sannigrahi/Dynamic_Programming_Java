import java.util.*;

public class Min_PathSum {

	public static int result(int i, int j, int[][] grid, int[][] dp) {
		if (i == grid.length - 1 && j == grid[0].length - 1) {
			return grid[i][j];
		}

		if (i > grid.length - 1 || j > grid[0].length - 1) {
			return 100000000;
		}

		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		int ipath = grid[i][j] + result(i + 1, j, grid, dp);
		int jpath = grid[i][j] + result(i, j + 1, grid, dp);

		return dp[i][j] = Math.min(ipath, jpath);
	}

	public static int minSumPath(int[][] grid) {
		// Write your code here
		int[][] dp = new int[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				dp[i][j] = -1;
			}
		}
		return result(0, 0, grid, dp);
	}

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[][] grid = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		System.out.println(minSumPath(grid));
	}
}