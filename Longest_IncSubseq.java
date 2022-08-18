import java.util.*;

public class Longest_IncSubseq {

    public static int result(int i, int[] arr, int prev, int[][] dp) {

        if (i == arr.length) {
            return 0;
        }

        if (dp[i][prev + 1] != -1) {
            return dp[i][prev + 1];
        }

        int len = 0 + result(i + 1, arr, prev, dp);
        if (prev == -1 || arr[i] > arr[prev]) {
            len = Math.max(len, 1 + result(i + 1, arr, i, dp));
        }
        dp[i][prev + 1] = len;
        return dp[i][prev + 1];
    }

    public static int longestIncreasingSubsequence(int arr[]) {
        //Your code goes here
        int[][] dp = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        int prev = -1;
        int i = 0;
        return result(i, arr, prev, dp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(longestIncreasingSubsequence(arr));
    }
}